class Solution {
    public int missingNumber(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        Arrays.sort(nums);

        int max = nums[nums.length - 1];

        for (int i = 0; i < nums.length; i++){
            res.add(nums[i]);
        }

        for (int i = 0; i < max; i++){
            if (!res.contains(i)){
                return i;
            }
        }
        return max + 1;
    }
}