class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int num : nums){
            mpp.put(num, mpp.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : mpp.entrySet()){
            if(entry.getValue() == 2){
                res.add(entry.getKey());
            }
        }
        return res;
    }
}
