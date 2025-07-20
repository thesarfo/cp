class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        List<List<int[]>> a = IntStream.range(0, n)
                                       .mapToObj(i -> new ArrayList<int[]>())
                                       .collect(Collectors.toCollection(ArrayList::new));

        var b = new int[n];
        var c = Arrays.stream(edges)
                      .mapToInt(e -> e[2])
                      .boxed()
                      .collect(Collectors.toCollection(TreeSet::new));

        Arrays.stream(edges).forEach(d -> {
            a.get(d[0]).add(new int[]{d[1], d[2]});
            b[d[1]]++;
        });

        var e = IntStream.range(0, n)
                         .filter(i -> b[i] == 0)
                         .boxed()
                         .collect(Collectors.toCollection(LinkedList::new));

        var f = new ArrayList<Integer>();
        while (!e.isEmpty()) {
            var g = e.poll();
            f.add(g);
            a.get(g).forEach(h -> {
                if (--b[h[0]] == 0) e.offer(h[0]);
            });
        }

        var i = new ArrayList<>(c);
        int j = 0, l = i.size() - 1, m = -1;

        while (j <= l) {
            int o = j + ((l - j) >>> 1);
            int p = i.get(o);

            if (q(a, online, k, n, f, p)) {
                m = p;
                j = o + 1;
            } else l = o - 1;
        }

        return m;
    }

    private boolean q(List<List<int[]>> a, 
                      boolean[] b, long c, int d, 
                      List<Integer> e, int f) {
        var g = new long[d];
        Arrays.fill(g, Long.MAX_VALUE);
        g[0] = 0;

        e.stream()
         .filter(h -> g[h] <= c && b[h])
         .forEach(h -> {
             a.get(h).stream()
              .filter(i -> i[1] >= f && b[i[0]])
              .forEach(i -> {
                  int j = i[0];
                  long k = g[h] + i[1];
                  if (k < g[j]) g[j] = k;
              });
         });

        return g[d - 1] <= c;
    }
}
