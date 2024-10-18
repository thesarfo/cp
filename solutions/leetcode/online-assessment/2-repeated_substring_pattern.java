class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String doubledString = s + s;
        return doubledString.substring(1, doubledString.length() - 1).contains(s);
    }
}