class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = Arrays.stream(nums)
                                .boxed()
                                .collect(Collectors.toSet());

        for(int i = k; i < Integer.MAX_VALUE; i++){
            if(i % k == 0 && !set.contains(i)){
                return i;
            }
        }
        return -1;
    }
}
