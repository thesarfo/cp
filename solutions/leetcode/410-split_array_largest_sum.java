public class Solution {
    public int splitArray(int[] nums, int k) {
        int max = 0, sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        int low = max, high = sum;
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isFeasible(nums, k, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    private boolean isFeasible(int[] nums, int k, int maxSum) {
        int subarrays = 1;
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum + num > maxSum) {
                subarrays++; 
                currentSum = num; 

                if (subarrays > k) {
                    return false; 
                }
            } else {
                currentSum += num; 
            }
        }

        return true;
    }
}