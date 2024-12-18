class Solution {
    public int nthRoot(int n, int m) {
        // code here
        int low = 0, high = m;
        
        while(low <= high){
            int mid = (low + high) / 2;
            double power = Math.pow(mid, n);
            
            if(power == m) return mid;
            else if(power > m) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}