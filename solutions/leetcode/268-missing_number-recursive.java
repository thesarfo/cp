class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        return helper(nums, 0);
    }

    public int helper(int[] nums, int index){

        if(index == nums.length) return index;

        if(nums[index] != index) return index;

        return helper(nums, index+1);
    }
}
