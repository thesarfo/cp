class Solution {
    public int dominantIndex(int[] nums) {
        int largest = 0;
        boolean fix = false;
        int idx = 0;

        for(int i = 0; i < nums.length; i++){
            if (nums[i] >= largest){
                largest = nums[i];
                idx = i;
            }
        }

        for(int num : nums){
            if((largest != num) && (largest < num * 2)){
                return -1;
            }
        }

        return idx;
    }
}