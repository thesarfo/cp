class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int[] res = new int[2];
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : mpp.entrySet()){
            if(entry.getValue() > 1){
                res[count++] = entry.getKey();
            }
        }
        return res;
    }
}