public class Solution {
    public static int search(int []nums, int target) {
        // Write your code here.
        int l = 0, r = nums.length - 1;
        
        while(l <= r){
            int mid = (l + r)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target){
                r = mid - 1;
            }
            else l = mid + 1;
        }
        return -1;
    }
}