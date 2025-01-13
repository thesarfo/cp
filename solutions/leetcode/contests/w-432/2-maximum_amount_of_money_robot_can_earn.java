class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        
        int[][][] dp = new int[m][n][3];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }
        
        dp[0][0][2] = coins[0][0];
        if (coins[0][0] < 0) {
            dp[0][0][1] = 0;
        }
        
        for (int j = 1; j < n; j++) {
            for (int k = 0; k <= 2; k++) {
                if (dp[0][j-1][k] != Integer.MIN_VALUE) {
                    dp[0][j][k] = dp[0][j-1][k] + coins[0][j];
                    
                    if (coins[0][j] < 0 && k > 0) {
                        dp[0][j][k-1] = Math.max(dp[0][j][k-1], dp[0][j-1][k]);
                    }
                }
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int k = 0; k <= 2; k++) {
                if (dp[i-1][0][k] != Integer.MIN_VALUE) {
                    dp[i][0][k] = dp[i-1][0][k] + coins[i][0];
                    
                    if (coins[i][0] < 0 && k > 0) {
                        dp[i][0][k-1] = Math.max(dp[i][0][k-1], dp[i-1][0][k]);
                    }
                }
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 0; k <= 2; k++) {
                    int fromUp = dp[i-1][j][k];
                    int fromLeft = dp[i][j-1][k];
                    if (fromUp != Integer.MIN_VALUE || fromLeft != Integer.MIN_VALUE) {
                        int maxPrev = Math.max(fromUp, fromLeft);
                        dp[i][j][k] = Math.max(dp[i][j][k], maxPrev + coins[i][j]);
                        if (coins[i][j] < 0 && k > 0) dp[i][j][k-1] = Math.max(dp[i][j][k-1], maxPrev);
                    }
                }
            }
        }
        
        int result = Integer.MIN_VALUE;
        for (int k = 0; k <= 2; k++) result = Math.max(result, dp[m-1][n-1][k]);
        return result;
    }
}