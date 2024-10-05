class Solution {
    public int findGCD(int[] nums) {
        int smallest = nums[0];
        int highest = nums[0];
        int gcd = 1;

        for(int i = 0; i < nums.length; i++){
            if (nums[i] <= smallest){
                smallest = nums[i];
            }
            if (nums[i] > highest){
                highest = nums[i];
            }
        }
        for (int i = Math.min(smallest, highest); i > 0; i--){
            if (smallest % i == 0 && highest % i == 0){
                return i;
            }
        }
        return 1;
    }
}