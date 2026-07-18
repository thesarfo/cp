class Solution {
    public int findGCD(int[] nums) {
        int min = nums[0], max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        while (max != 0) {
            int temp = max;
            max = min % max;
            min = temp;
        }
        return min;
    }
}
