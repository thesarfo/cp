import java.lang.Math;

class Solution {
    public int maxSubArray(int[] nums) {
        int maxI = Integer.MIN_VALUE; 

        for (int i = 0; i < nums.length; i++) {
            int sum = 0; 
            for (int j = i; j < nums.length; j++) {
                sum += nums[j]; 
                maxI = Math.max(maxI, sum);
            }
        }
        return maxI;
    }
}
