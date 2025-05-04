class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;

        int index = 0, total = 0, sign = 1;
        int n = s.length();

        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        if (index == n) return 0;

        char ch = s.charAt(index);
        if (ch == '+' || ch == '-') {
            sign = (ch == '-') ? -1 : 1;
            index++;
        }

        while (index < n) {
            char currentChar = s.charAt(index);
            if (currentChar < '0' || currentChar > '9') break;

            int digit = currentChar - '0';

            if (total > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = total * 10 + digit;
            index++;
        }

        return total * sign;
    }
}
