class Solution {
    public int minOperations(int[] nums, int k) {
        int s = 0;
        for (int n : nums) {
            s += n;
        }
        int rm = s % k;
        return rm == 0 ? 0 : rm;
    }
}