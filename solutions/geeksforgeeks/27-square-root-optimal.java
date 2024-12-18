
class Solution {
    int floorSqrt(int n) {
        // Your code here
        int low = 1, high = n;
        int ans = 1;
        
        while(low <= high){
            int mid = (low + high) / 2;
            
            if(mid * mid > n){
                high = mid - 1;
            } else{
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }
    
}