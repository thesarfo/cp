class Solution {
    public int minOperations(int[] nums, int k) {
        for (int num : nums) {
            if (num < k) {
                return -1;
            }
        }

        Arrays.sort(nums);

        int ops = 0;
        int pval = -1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > k && nums[i] != pval) {
                pval = nums[i];
                ops++;
            }
            if (nums[i] == k) {
                break;
            }
        }

        return ops;
    }
}
