class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int repeating = -1, missing = -1;

        for(int i = 1; i <= n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(nums[j] == i) count++;
            }
            if(count == 2) repeating = i;
            else if(count == 0) missing = i;
            if(repeating != -1 && missing != -1) break;
        }
        int[] ans = {repeating, missing};
        return ans;
    }
}