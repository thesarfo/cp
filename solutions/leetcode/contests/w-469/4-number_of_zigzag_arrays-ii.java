class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int k = r - l + 1;
        if(n == 1) return k;
        int mod = 1_000_000_007;

        BiFunction<int[][], int[][], int[][]> txt = (a,b) ->{
            int ttl = a.length;
            int[][] c = new int[ttl][ttl];
            IntStream.range(0, ttl).forEach(i ->
                IntStream.range(0, ttl).filter(x -> a[i][x] != 0).forEach(x -> {
                    long md = a[i][x];
                    for (int j = 0; j < ttl; ++j)
                        c[i][j] = (int)((c[i][j] + md * b[x][j]) % mod);
                })
            );
            return c;
        };

        BiFunction<int[][], Long, int[][]> rng = (rrt, exp) -> {
            int ttl = rrt.length;
            int[][] sln = new int[ttl][ttl];
            for (int i = 0; i < ttl; i++) sln[i][i] = 1;
            int[][] prs = rrt;
            for (long e = exp; e > 0; e >>= 1) {
                if ((e & 1) == 1) sln = txt.apply(sln, prs);
                prs = txt.apply(prs, prs);
            }
            return sln;
        };

        int[][] atb = new int[k][k], nif = new int[k][k];
        IntStream.range(0, k).forEach(y ->
            IntStream.range(0, k).forEach(x -> {
                if (x < y) atb[y][x] = 1;
                else if (x > y) nif[y][x] = 1;
            })
        );

        int[][] swt = new int[2 * k][2 * k];
        IntStream.range(0, k).forEach(i ->
            IntStream.range(0, k).forEach(j -> {
                swt[i][k + j] = atb[i][j];
                swt[k + i][j] = nif[i][j];
            })
        );

        int[] bgn = IntStream.range(0, 2 * k)
            .map(x -> x < k ? x : 2 * k - 1 - x)
            .toArray();


        int[][] xp = rng.apply(swt, (long) n - 2);
        int[] lng = new int[2 * k];
        IntStream.range(0, 2 * k).forEach(i -> {
            long s = 0;
            for (int j = 0; j < 2 * k; ++j) {
                if (xp[i][j] != 0) s += (long) xp[i][j] * bgn[j];
                if (s >= (1L << 50)) s %= mod;
            }
            lng[i] = (int)(s % mod);
        });

        return (int)(Arrays.stream(lng).asLongStream().sum() % mod);
    }
}