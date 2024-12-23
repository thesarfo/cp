class Solution {
    public long findTheArrayConcVal(int[] nums) {
        int low = 0, high = nums.length - 1;
        long concValue = 0;

        while (low <= high) {
            if (low == high) {
                concValue += nums[low];
            } else {
                concValue += Long.valueOf(String.valueOf(nums[low]) + 
String.valueOf(nums[high]));
            }
            low++;
            high--;
        }
        return concValue;
    }
}

