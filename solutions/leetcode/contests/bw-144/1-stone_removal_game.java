class Solution {
    public boolean canAliceWin(int n) {
        int st = 10;  
        int t = 1;   

        while (n >= st) {
            n -= st;  
            t *= -1;      
            st--;
        }

        return t == -1;  
    }
}