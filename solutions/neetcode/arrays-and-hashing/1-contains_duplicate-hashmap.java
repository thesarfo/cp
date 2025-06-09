class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> mpp = new HashMap<>();

        for (int num : nums) {
            mpp.put(num, mpp.getOrDefault(num, 0) + 1);
        }

        for (int count : mpp.values()) {
            if (count > 1) {
                return true;
            }
        }

        return false;
    }
}
