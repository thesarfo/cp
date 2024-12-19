class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Integer.MIN_VALUE;

        for (int num : nums) {
            high = Math.max(high, num);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            int result = divide(nums, mid);

            if (result <= threshold) {
                high = mid; 
            } else {
                low = mid + 1; 
            }
        }

        return low;
    }

    private int divide(int[] nums, int divisor) {
        int sum = 0;
        for (int num : nums) {
            sum += Math.ceil((double) num / divisor);
        }
        return sum;
    }
}
