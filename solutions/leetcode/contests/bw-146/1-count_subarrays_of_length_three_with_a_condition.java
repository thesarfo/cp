class Solution {
    public int countSubarrays(int[] nums) {
        int startIndex = 0, endIndex = 0, resultCount = 0;

        while (endIndex < nums.length) {
            if (endIndex - startIndex + 1 >= 3) {
                if ((nums[startIndex] + nums[endIndex]) * 2 == nums[startIndex + 1]) {
                    resultCount++;
                }
                startIndex++;
            }
            endIndex++;
        }
        return resultCount;
    }
}
