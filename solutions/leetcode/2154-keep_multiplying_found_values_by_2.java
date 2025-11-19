class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> st = new HashSet<>();
        for (int n : nums) {
            st.add(n);
        }

        while (st.contains(original)) {
            original *= 2;
        }

        return original;
    }
}
