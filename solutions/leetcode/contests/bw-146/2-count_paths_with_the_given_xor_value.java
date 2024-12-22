class Solution {
    public int countPathsWithXorValue(int[][] grid, int targetXor) {
        int maxXorValue = 15;
        int numRows = grid.length;
        int numCols = grid[0].length;
        final int MOD = 1_000_000_007;

        int[][][] dp = new int[numRows][numCols][maxXorValue + 1];
        dp[0][0][grid[0][0]] = 1;

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                for (int currentXor = 0; currentXor <= maxXorValue; currentXor++) {
                    if (dp[row][col][currentXor] > 0) {
                         if (col + 1 < numCols) {
                            int newXor = currentXor ^ grid[row][col + 1];
                            dp[row][col + 1][newXor] = (dp[row][col + 1][newXor] + dp[row][col][currentXor]) % MOD;
                        }
                         if (row + 1 < numRows) {
                            int newXor = currentXor ^ grid[row + 1][col];
                            dp[row + 1][col][newXor] = (dp[row + 1][col][newXor] + dp[row][col][currentXor]) % MOD;
                        }
                    }
                }
            }
        }

        return dp[numRows - 1][numCols - 1][targetXor];
    }
}
