class Solution {
    public int smallestNumber(int n) {
        int a = n;
        
        while ((a & (a + 1)) != 0) {
            a++;
        }
        
        return a;
    }
}
