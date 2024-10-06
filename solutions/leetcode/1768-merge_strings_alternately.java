class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        StringBuilder result = new StringBuilder();
        int i = 0;
        int j = 0;

        while(i < m || j < n){
            if (i < m){
                result.append(word1.charAt(i));
                i++;
            } 
            if (j < n){
                result.append(word2.charAt(j));
                j++;
            }
        }
        return result.toString();
    }
}