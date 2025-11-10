class Solution {
    public boolean isPalindrome(String s) {
        return check(s, 0, s.length() - 1);
    }

    private boolean check(String s, int start, int end){

        while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
            start++;
        }

        while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {
            end--;
        }
        if(start >= end) return true;

        if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) return false;

        return check(s, start + 1, end - 1);
    }
}