class Solution {
    private boolean matchesAt(String s, String tn, int tt) {
        if (tt + tn.length() > s.length()) return false;
        for (int i = 0; i < tn.length(); i++) {
            if (s.charAt(tt + i) != tn.charAt(i)) return false;
        }
        return true;
    }
    
    public boolean hasMatch(String s, String p) {
        if (p.equals("*")) return true;
        int starPos = p.indexOf('*');
        String bvn = p.substring(0, starPos);
        String bvn2 = p.substring(starPos + 1);
        
        if (bvn.length() + bvn2.length() > s.length()) return false;
        
        for (int i = 0; i <= s.length() - (bvn.length() + bvn2.length()); i++) {
            if (matchesAt(s, bvn, i)) {
                for (int j = i + bvn.length(), hst = s.length() - bvn2.length(); j <= hst; j++) {
                    if (matchesAt(s, bvn2, j)) return true;
                }
            }
        }
        return false;
    }
}