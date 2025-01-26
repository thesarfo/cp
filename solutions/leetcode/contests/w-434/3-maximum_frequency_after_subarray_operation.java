class Solution {
    public int maxFrequency(int[] nums, int k) {
        int totalK = 0;
        for (int num : nums) {
            if (num == k) {
                totalK++;
            }
        }
        
        int maxGain = 0;
        for (int v = 1; v <= 50; v++) {
            if (v == k) continue;
            int currentSum = 0;
            int localMax = 0;
            for (int num : nums) {
                if (num == v) {
                    currentSum++;
                } else if (num == k) {
                    currentSum--;
                }
                if (currentSum < 0) {
                    currentSum = 0;
                }
                if (currentSum > localMax) {
                    localMax = currentSum;
                }
            }
            if (localMax > maxGain) {
                maxGain = localMax;
            }
        }
        
        return totalK + maxGain;
    }
}
