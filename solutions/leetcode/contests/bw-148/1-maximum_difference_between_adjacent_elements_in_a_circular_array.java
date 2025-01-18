class Solution {
    public int maxAdjacentDistance(int[] nums) {
        return nums == null || nums.length < 2 ? 0 : java.util.stream.IntStream.range(0, nums.length).map(i -> Math.abs(nums[i] - nums[(i + 1) % nums.length])).max().getAsInt();
    }
}