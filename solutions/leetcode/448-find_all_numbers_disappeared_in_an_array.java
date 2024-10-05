class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> oldNums = new HashSet<>();
        List<Integer> newNums = new ArrayList<>();

        for (int i = 0; i < nums.length; i++){
            oldNums.add(nums[i]);
        }

        for (int i = 1; i <= nums.length; i++){
            if (!oldNums.contains(i)){
                newNums.add(i);
            }
        }
        return newNums;
    }
}