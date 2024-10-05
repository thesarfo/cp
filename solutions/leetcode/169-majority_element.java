class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> hash = new HashMap<>();

        for(int i = 0; i < n; i++){
            int value = hash.getOrDefault(nums[i], 0);
            hash.put(nums[i], value + 1);
        }

        for(Map.Entry<Integer, Integer> it : hash.entrySet()){
            if(it.getValue() > (n/2)){
                return it.getKey();
            }
        }

        return -1;
    }
}