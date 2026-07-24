class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int x : nums) max = Math.max(max, x);
        int bits = 32 - Integer.numberOfLeadingZeros(max);
        int limit = 1 << bits;

        boolean[] pairXor = new boolean[limit];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                pairXor[nums[i] ^ nums[j]] = true;
            }
        }

        boolean[] tripleXor = new boolean[limit];
        int count = 0;
        for (int p = 0; p < limit; p++) {
            if (!pairXor[p]) continue;
            for (int k = 0; k < n; k++) {
                int v = p ^ nums[k];
                if (!tripleXor[v]) {
                    tripleXor[v] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
