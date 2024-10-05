class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        
        k = k % n;

        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = nums[n - k + i];
        }
        
        for (int i = n - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }
        
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }
}