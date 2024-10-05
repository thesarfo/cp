class Solution {
    public boolean check(int[] nums) {
        int[] newNums = nums.clone();
        Arrays.sort(newNums);

        int n = nums.length;
        if (n == newNums.length) {
            for (int i = 0; i < n; i++) {
                boolean isRotation = true;
                for (int j = 0; j < n; j++) {
                    if (nums[j] != newNums[(i + j) % n]) {
                        isRotation = false;
                        break;
                    }
                }
                if (isRotation) {
                    return true;
                }
            }
        }
        return false;
    }
}
