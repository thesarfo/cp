class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxi = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                count++;
                maxi = Math.max(count, maxi);
            } else{
                count = 0;
            }
        }

        return maxi;
    }
}