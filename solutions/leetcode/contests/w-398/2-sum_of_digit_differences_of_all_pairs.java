class Solution {
    public long sumDigitDifferences(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        int numDigits = String.valueOf(nums[0]).length();
        
        int[][] digitCount = new int[numDigits][10];

        for (int num : nums) {
            String s = String.valueOf(num);
            for (int i = 0; i < numDigits; i++) {
                int digit = s.charAt(i) - '0';
                digitCount[i][digit]++;
            }
        }

        long totalDifference = 0;

        
        for (int i = 0; i < numDigits; i++) {
            for (int digit = 0; digit < 10; digit++) {
                int count = digitCount[i][digit];
                if (count > 0) {
                    int differentCount = n - count;
                    totalDifference += count * differentCount;
                }
            }
        }


        return totalDifference / 2;
    }
}