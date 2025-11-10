class Solution {
    public boolean validPalindrome(String s) {
        return check(s, 0, s.length() - 1, false);
    }

    private boolean check(String s, int start, int end, boolean skipped) {
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                if (skipped) return false;

                return check(s, start + 1, end, true) || check(s, start, end - 1, true);
            }
        }
        return true; 
    }
}
