class Solution {
    public int maxSubArray(int[] nums) {
        int maxI = Integer.MIN_VALUE; 

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0; 
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                maxI = Math.max(maxI, sum);
            }
        }
        return maxI;
    }
}