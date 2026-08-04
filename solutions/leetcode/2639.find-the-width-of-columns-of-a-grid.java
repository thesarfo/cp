/*
 * @lc app=leetcode id=2639 lang=java
 *
 * [2639] Find the Width of Columns of a Grid
 */

// @lc code=start
class Solution {
    public int[] findColumnWidth(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return new int[0];
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int[] res = new int[cols];

        for (int c = 0; c < cols; c++) {
            int maxWidth = 0;
            for (int r = 0; r < rows; r++) {
                int currentLength = String.valueOf(grid[r][c]).length();
                maxWidth = Math.max(maxWidth, currentLength);
            }
            res[c] = maxWidth;
        }

        return res;
    }
}   
// @lc code=end

