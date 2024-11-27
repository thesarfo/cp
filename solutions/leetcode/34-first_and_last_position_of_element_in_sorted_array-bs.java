class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1}; 
        
        if (nums.length == 0) {
            return res;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;  
            if (nums[mid] == target) {
                res[0] = mid;
                right = mid - 1;  
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (res[0] == -1) {
            return res;
        }

        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                res[1] = mid;
                left = mid + 1;  
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }
}