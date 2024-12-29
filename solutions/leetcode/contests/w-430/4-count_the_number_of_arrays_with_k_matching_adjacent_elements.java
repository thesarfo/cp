class Solution {
    private static final int MOD = 1000000007;

    private long power(long x, long y) {
        long result = 1;
        x = x % MOD;
        while (y > 0) {
            if ((y & 1) == 1) { // If y is odd
                result = (result * x) % MOD;
            }
            x = (x * x) % MOD;
            y = y >> 1; // Right shift y
        }
        return result;
    }

    private long modInverse(long a) {
        return power(a, MOD - 2);
    }

    private long nCr(long n, long r) {
        if (r > n) {
            return 0;
        }
        if (r == 0) {
            return 1;
        }

        long num = 1, den = 1;
        for (long i = 0; i < r; i++) {
            num = (num * (n - i)) % MOD;
            den = (den * (i + 1)) % MOD;
        }

        return (num * modInverse(den)) % MOD;
    }

    public int countGoodArrays(int n, int m, int k) {
        if (k >= n) {
            return 0;
        }

        long kpos = nCr(n - 1, k);
        long rem = power(m - 1, n - k - 1);
        long ans = (kpos * m) % MOD;
        ans = (ans * rem) % MOD;

        return (int) ans;
    }
}
