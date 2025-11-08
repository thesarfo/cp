class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        return (int) IntStream.range(0, n)
            .mapToLong(i -> IntStream.range(i, n)
                .filter(j -> {
                    int total = j - i + 1;
                    long count = IntStream.rangeClosed(i, j)
                        .filter(k -> nums[k] == target)
                        .count();
                    return count * 2 > total;
                }).count()
            ).sum();
    }
}