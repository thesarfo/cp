class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length, c = 0;
        boolean[][] v = new boolean[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] > 0 && !v[i][j]) {
                    int[] s = new int[1];
                    d(grid, v, i, j, s);
                    if (s[0] % k == 0) c++;
                }
        return c;
    }

    void d(int[][] grid, boolean[][] v, int i, int j, int[] s) {
        int M = grid.length, N = grid[0].length;
        if (i < 0 || i >= M || j < 0 || j >= N || grid[i][j] <= 0 || v[i][j]) return;
        v[i][j] = true;
        s[0] += grid[i][j];
        d(grid, v, i + 1, j, s);
        d(grid, v, i - 1, j, s);
        d(grid, v, i, j + 1, s);
        d(grid, v, i, j - 1, s);
    }
}
