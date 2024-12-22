class Solution {
    public int firstMissingPositive(int[] nums) {
        HashMap<Integer, Boolean> mpp = new HashMap<>();
        int n = nums.length;

        for (int num : nums) {
            if (num > 0) { 
                mpp.put(num, true);
            }
        }

        for (int i = 1; i <= n + 1; i++) { 
            if (!mpp.containsKey(i)) {
                return i; 
            }
        }

        return -1; 
    }
}

