class Solution {
    public long maxProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        
        int min1 = nums[0], min2 = nums[1];
        int max1 = nums[n-1], max2 = nums[n-2], max3 = nums[n-3];
        
        int[] REPLACE = {-100_000, 100_000};
        long res = Long.MIN_VALUE;
        
        int[] arr1 = {max1, max2, max3};
        for (int i = 0; i < 3; i++) {
            for (int r : REPLACE) {
                int[] temp = arr1.clone();
                temp[i] = r;
                long prod = (long)temp[0] * temp[1] * temp[2];
                res = Math.max(res, prod);
            }
        }
        
        int[] arr2 = {min1, min2, max1};
        for (int i = 0; i < 3; i++) {
            for (int r : REPLACE) {
                int[] temp = arr2.clone();
                temp[i] = r;
                long prod = (long)temp[0] * temp[1] * temp[2];
                res = Math.max(res, prod);
            }
        }
        
        return res;
    }
}