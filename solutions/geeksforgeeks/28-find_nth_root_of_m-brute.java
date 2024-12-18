class Solution {
    public int nthRoot(int n, int m) {
        // code here
        for(int i = 1; i <= m; i++){
            double power = Math.pow(i, n);
            
            if(power == m) return i;
            else if(power > m) break;
        }
        return -1;
    }
}