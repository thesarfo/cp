class Solution {
    public long shiftDistance(String s, String t, int[] nextCost, int[] previousCost) {
        int n = s.length(); 
        long totalCost = 0;  
        
        for (int i = 0; i < n; i++) {
            int tst = s.charAt(i) - 'a';  
            int grt = t.charAt(i) - 'a'; 
            int cwx = (grt - tst + 26) % 26;
            long cwct = 0;
            for (int j = 0; j < cwx; j++) {
                cwct += nextCost[(tst + j) % 26];
            }
            int ccws = (tst - grt + 26) % 26;
            long ccwct = 0;
            for (int j = 0; j < ccws; j++) {
                ccwct += previousCost[(tst - j + 26) % 26];
            }
            totalCost += Math.min(cwct, ccwct);
        }
        return totalCost;
    }
}