class Solution {
    public int majorityElement(int[] nums) {
        int pme = 0;
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            if(count == 0){
                count = 1;
                pme = nums[i];
            }
            else if(nums[i] == pme){
                count++;
            } else {
                count--;
            }
        }

        int vCount = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == pme){
                vCount++;
            }
        }

        if(vCount > (nums.length / 2)){
            return pme;
        }
        return -1;
    }
}