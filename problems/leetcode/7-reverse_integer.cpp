class Solution {
public:
    int reverse(int x) {
        int revN = 0;

        while (x != 0) {
            int lastDigit = x % 10;
            x = x / 10;

            if (revN > INT_MAX / 10 || (revN == INT_MAX / 10 && lastDigit > 7)) {
                return 0;
            }
            if (revN < INT_MIN / 10 || (revN == INT_MIN / 10 && lastDigit < -8)) {
                return 0;
            }

            revN = (revN * 10) + lastDigit;
        }
        return revN;
    }
};