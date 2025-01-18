class Solution {
    public long minCost(int[] a, int[] b, long k) {
        int n = a.length;
        long w = 0;
        for (int i = 0; i < n; i++) w += Math.abs(a[i] - b[i]);
        if (n > 1) {
            Arrays.sort(a); Arrays.sort(b);
            long c = 0;
            for (int i = 0; i < n; i++) c += Math.abs(a[i] - b[i]);
            c += k;
            return Math.min(w, c);
        }
        return w;
    }
}