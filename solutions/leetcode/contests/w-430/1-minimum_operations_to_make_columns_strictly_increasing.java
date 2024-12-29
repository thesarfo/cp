class Solution {
    public int minimumOperations(int[][] grid) {
        int count = 0;

        for (int i = 0; i < grid[0].length; i++) {
            int curr = grid[0][i];

            for (int j = 1; j < grid.length; j++) {
                if (grid[j][i] <= curr) {
                    count += curr - grid[j][i] + 1;
                    grid[j][i] = curr + 1;
                }
                curr = grid[j][i];
            }
        }

        return count;
    }
}
