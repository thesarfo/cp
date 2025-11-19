class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        generateSubsets(0, nums, current, result);
        return result;
    }

    private void generateSubsets(int index, int[] nums, 
                                 List<Integer> current, 
                                 List<List<Integer>> result) {

        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        generateSubsets(index + 1, nums, current, result);

        current.remove(current.size() - 1);

        generateSubsets(index + 1, nums, current, result);
    }
}
