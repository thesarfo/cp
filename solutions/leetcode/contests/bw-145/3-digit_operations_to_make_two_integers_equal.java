import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int minOperations(int n, int m) {
        boolean[] prm = vvs(9999);
        if (prm[n] || prm[m]) return -1;
        int ndg = (n == 0) ? 1 : (int) Math.log10(n) + 1;

        int xm = 10000;
        long[] msa = new long[xm];
        Arrays.fill(msa, Long.MAX_VALUE);
        msa[n] = n;

        PriorityQueue<int[]> qp = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        qp.offer(new int[]{n, n});

        while (!qp.isEmpty()) {
            int[] c = qp.poll();
            long cs = c[0];
            int cn = c[1];

            if (cn == m) return (int) cs;

            if (cs > msa[cn]) continue;
            String ns = Integer.toString(cn);
            while (ns.length() < ndg) ns = "0" + ns;
            for (int i = 0; i < ndg; i++) {
                char gd = ns.charAt(i);
                if (gd < '9') {
                    StringBuilder nns = new StringBuilder(ns);
                    nns.setCharAt(i, (char) (gd + 1));
                    if (nns.charAt(0) != '0') {
                        int nn = Integer.parseInt(nns.toString());
                        if (!prm[nn]) {
                            long nws = cs + nn;
                            if (nws < msa[nn]) {
                                msa[nn] = nws;
                                qp.offer(new int[]{(int) nws, nn});
                            }
                        }
                    }
                }

                if (gd > '0') {
                    StringBuilder nns = new StringBuilder(ns);
                    nns.setCharAt(i, (char) (gd - 1));
                    if (nns.charAt(0) != '0') {
                        int nn = Integer.parseInt(nns.toString());
                        if (!prm[nn]) {
                            long nws = cs + nn;
                            if (nws < msa[nn]) {
                                msa[nn] = nws;
                                qp.offer(new int[]{(int) nws, nn});
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    private boolean[] vvs(int mlt) {
        boolean[] prm = new boolean[mlt + 1];
        Arrays.fill(prm, true);
        prm[0] = prm[1] = false;
        for (int i = 2; i * i <= mlt; i++) {
            if (prm[i]) {
                for (int j = i * i; j <= mlt; j += i) {
                    prm[j] = false;
                }
            }
        }
        return prm;
    }
}