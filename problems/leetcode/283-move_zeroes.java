class Solution {
    public void moveZeroes(int[] nums) {
        ArrayList<Integer> withOut = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                withOut.add(nums[i]);
            }
        }

        int numZeros = nums.length - withOut.size();

        for(int i = 0; i < numZeros; i++){
            withOut.add(0);
        }
        
        for(int i = 0; i < withOut.size(); i++){
            nums[i] = withOut.get(i);
        }
    }
}