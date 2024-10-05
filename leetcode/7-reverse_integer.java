class Solution {
    public int reverse(int x) {
        int revN = 0;

        while (x != 0) {
            int lastDigit = x % 10;
            x = x / 10;

            if (revN > Integer.MAX_VALUE / 10 || (revN == Integer.MAX_VALUE / 10 && lastDigit > 7)) {
                return 0;
            }
            if (revN < Integer.MIN_VALUE / 10 || (revN == Integer.MIN_VALUE / 10 && lastDigit < -8)) {
                return 0;
            }

            revN = (revN * 10) + lastDigit;
        }
        return revN;
    }
}