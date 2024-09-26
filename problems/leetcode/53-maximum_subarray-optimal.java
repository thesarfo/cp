class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currentSum = 0;

        for(int i = 0; i < nums.length; i++){
            currentSum += nums[i];

            if (currentSum > maxSoFar) {
                maxSoFar = currentSum;
            }

            if(currentSum < 0){
                currentSum = 0;
            }
        }
        return maxSoFar;
    }
}
