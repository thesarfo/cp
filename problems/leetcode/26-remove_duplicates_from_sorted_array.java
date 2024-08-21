class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int lastUniqueIndex = 0;

        for (int i = 1; i < nums.length; i++){
            if (nums[i] != nums[lastUniqueIndex]){
                lastUniqueIndex++;
                nums[lastUniqueIndex] = nums[i];
            }
        }
        return lastUniqueIndex + 1;
    }
}
