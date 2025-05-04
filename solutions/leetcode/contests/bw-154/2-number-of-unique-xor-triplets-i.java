class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return n;
        } else {
            int msb = Integer.highestOneBit(n);
            return 2 * msb;
        }
    }
}