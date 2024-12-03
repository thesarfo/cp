class Solution {
    public int[] runningSum(int[] nums) {
        int sum = 0;
        int[] nnums = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            nnums[i] = sum;
        }
        return nnums;
    }
}