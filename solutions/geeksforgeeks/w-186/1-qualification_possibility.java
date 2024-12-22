class Solution {
    public static boolean isPossible(String s) {
        // code here
        int n = s.length();
        int wcount = 0;
        
        for(char c : s.toCharArray()){
            if(c == 'W'){
                wcount++;
            }
        }
        
        int remaining = 14 - n;
        int maxwins = wcount + remaining;
        
        return maxwins >= 8;
    }
}
