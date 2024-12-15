class Solution {
    public int beautifulSplits(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;

        int count = 0;

        long[] prefixHash = new long[n];
        long[] base = new long[n];
        final int MOD = (int) 1e9 + 7;
        final int PRIME = 31;

        prefixHash[0] = nums[0];
        base[0] = 1;
        for (int i = 1; i < n; ++i) {
            prefixHash[i] = (prefixHash[i - 1] * PRIME + nums[i]) % MOD;
            base[i] = (base[i - 1] * PRIME) % MOD;
        }

        for (int i = 1; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (isPrefix(prefixHash, base, 0, i, i, j, MOD) || isPrefix(prefixHash, base, i, j, j, n, MOD)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isPrefix(long[] prefixHash, long[] base, int start1, int end1, int start2, int end2, int MOD) {
        int len1 = end1 - start1;
        int len2 = end2 - start2;
        if (len1 > len2) return false;

        long hash1 = prefixHash[end1 - 1];
        if (start1 > 0) {
            hash1 = (hash1 - prefixHash[start1 - 1] * base[len1] % MOD + MOD) % MOD;
        }

        long hash2 = prefixHash[start2 + len1 - 1];
        if (start2 > 0) {
            hash2 = (hash2 - prefixHash[start2 - 1] * base[len1] % MOD + MOD) % MOD;
        }

        return hash1 == hash2;
    }
}
