class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] pos = new int[nums.length / 2]; 
        int[] neg = new int[nums.length / 2]; 
        int posIndex = 0; 
        int negIndex = 0; 

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) {
                neg[negIndex++] = nums[i]; 
            } else {
                pos[posIndex++] = nums[i]; 
            }
        }

        for(int i = 0; i < nums.length / 2; i++) {
            nums[2 * i] = pos[i];
            nums[2 * i + 1] = neg[i]; 
        }

        return nums;
    }
}
