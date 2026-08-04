/*
 * @lc app=leetcode id=2639 lang=java
 *
 * [2639] Find the Width of Columns of a Grid
 */

// @lc code=start
class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int cols = grid[0].length;
        int rows = grid.length;

        int[] res = new int[cols]; 
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int len = String.valueOf(grid[r][c]).length();
                res[c] = Math.max(res[c], len);
            }
        }
        return res;
    }
}   
// @lc code=end

