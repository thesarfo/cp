class Solution {
    public static int numWays(String s) {
        int MOD = 1000000007;
        int n = s.length();

        int[] dp = new int[n];
        dp[0] = 1; 

        for (int i = 0; i < n; i++) {
            if (dp[i] == 0) continue;
            if (i + 1 < n) dp[i + 1] = (dp[i + 1] + dp[i]) % MOD;
            if (i + 2 < n && s.charAt(i) == '0') dp[i + 2] = (dp[i + 2] + 
dp[i]) % MOD;
        }

        return dp[n - 1];
    }
}
