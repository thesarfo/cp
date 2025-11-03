class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int smallest = nums[0], largest = nums[0];
        ArrayList<Integer> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if(nums[i] < smallest) smallest = nums[i];
            if(nums[i] > largest) largest = nums[i];
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for(int i = smallest; i <= largest; i++){
            if(!set.contains(i)){
                res.add(i);
            }
        }

        System.out.println(res);
        return res;
        
    }
}