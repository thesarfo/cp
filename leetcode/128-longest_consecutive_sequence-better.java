class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums); 

        int longest = 1, count_curr = 1, last_smaller = nums[0];  
        for(int i = 1; i < nums.length; i++){
            if(nums[i] - 1 == last_smaller){  
                count_curr++; 
                last_smaller = nums[i]; 
            }
            else if(nums[i] == last_smaller){ 
                continue;
            }
            else{
                count_curr = 1;  
                last_smaller = nums[i];  
            }

            longest = Math.max(longest, count_curr);  
        }
        return longest;
    }
}