class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            result.add(row);
        }

        int total = m * n;
        k = k % total;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int pos = (i * n + j + k) % total;
                int newRow = pos / n;
                int newCol = pos % n;
                result.get(newRow).set(newCol, grid[i][j]);
            }
        }

        return result;
    }
}
