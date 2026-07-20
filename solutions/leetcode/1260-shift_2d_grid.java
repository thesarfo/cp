class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int total = m * n;
        k %= total;
        List<List<Integer>> result = new ArrayList<>();
        int[] flat = new int[total];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                flat[i * n + j] = grid[i][j];
            }
        }
        int[] shifted = new int[total];
        for (int idx = 0; idx < total; idx++) {
            shifted[(idx + k) % total] = flat[idx];
        }
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(shifted[i * n + j]);
            }
            result.add(row);
        }
        return result;
    }
}
