class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int firstSum = n * (n + 1) / 2;
        int secondSum = 0;

        for(int i = 0; i < n; i++){
            secondSum += nums[i];
        }

        return firstSum - secondSum;
    }
}