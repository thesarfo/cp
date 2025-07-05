class Solution {
    public String concatHex36(int n) {
        int ns = n * n;
        int nc = n * n * n;
        
        String hx = Integer.toString(ns, 16).toUpperCase();
        String hx36 = Integer.toString(nc, 36).toUpperCase();
        
        return hx + hx36;
    }
}