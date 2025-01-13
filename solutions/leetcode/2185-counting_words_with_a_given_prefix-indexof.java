public class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (word.length() >= pref.length() && word.indexOf(pref) == 0) {
                count++;
            }
        }
        return count;
    }
}
