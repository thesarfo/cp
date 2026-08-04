class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        int smallest = nums[0];
        int largest = nums[nums.length - 1];

        Set<Integer> set = Arrays.stream(nums)
                               .boxed()
                               .collect(Collectors.toSet());

        for(int i = smallest; i < largest; i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }
        return list;
    }
}
