class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] answer = new int[nums.length];
        int posIndex = 0;
        int negIndex = 1;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                answer[negIndex] = nums[i];
                negIndex += 2;
            } else{
                answer[posIndex] = nums[i];
                posIndex += 2;
            }
        }
        return answer;
    }
}