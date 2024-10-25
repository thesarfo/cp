class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        long total = 0;
        int maxFreq = 1;

        for(int right = 0; right < nums.length; right++){
            total += nums[right];

            while((long) nums[right] * (right - left + 1) - total > k){
                total -= nums[left];
                left++;
            }
            maxFreq = Math.max(maxFreq, right - left + 1);
        }
        return maxFreq;
    }
}
