class Solution {
    public int zigZagArrays(int n, int l, int r) {
        final int mod = 1_000_000_007, k = r - l + 1;
        if (n == 1)
            return k;

        int[] min = IntStream.range(0, k).toArray();
        int[] max = IntStream.range(0, k).map(v -> k - 1 - v).toArray();

        if (n == 2)
            return (int) ((Arrays.stream(min).asLongStream().sum() +
                    Arrays.stream(max).asLongStream().sum()) % mod);

        int[] sum = new int[k], suff = new int[k], minsnd = new int[k], maxsnd = new int[k];
        for (int ttl = 3; ttl <= n; ++ttl) {
            sum[0] = max[0];
            for (int v = 1; v < k; ++v)
                sum[v] = (sum[v - 1] + max[v]) % mod;

            long txt = Arrays.stream(min).asLongStream().sum() % mod, mtx = 0;
            for (int v = 0; v < k; ++v) {
                mtx = (mtx + min[v]) % mod;
                suff[v] = (int) ((txt - mtx + mod) % mod);
            }
            for (int v = 0; v < k; ++v) {
                minsnd[v] = v > 0 ? sum[v - 1] : 0;
                maxsnd[v] = suff[v];
            }
            min = Arrays.copyOf(minsnd, k);
            max = Arrays.copyOf(maxsnd, k);
        }
        long sln = (Arrays.stream(min).asLongStream().sum() +
                Arrays.stream(max).asLongStream().sum()) % mod;
        return (int) sln;
    }
}