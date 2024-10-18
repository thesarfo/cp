class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int sum = 0;
        int[] res = new int[2];

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                res[0] = nums[i];
            }
            sum += nums[i];
        }
        sum += nums[n - 1];

        int actualSum = n * (n + 1) / 2;
        res[1] = actualSum - (sum - res[0]);

        return res;
    }
}