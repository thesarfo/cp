class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] snk = new int[2];
        int idx = 0;

        HashMap<Integer, Integer> mpp = new HashMap<>();

        for(int n : nums){
            int count = mpp.getOrDefault(n, 0) + 1;
            mpp.put(n, count);
            if(count == 2){
                snk[idx++] = n;
                if (idx == 2) break;
            }
        }
        return snk;
    }
}