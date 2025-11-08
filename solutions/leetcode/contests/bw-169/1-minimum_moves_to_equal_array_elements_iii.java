class Solution {
    public int minMoves(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        return Arrays.stream(nums)
            .map(num -> max - num)
            .sum();
    }
}