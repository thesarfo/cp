class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length, result[][] = new int[n][n];
        for (int i = 0; i < n; i++) System.arraycopy(grid[i], 0, result[i], 0, n);
        
        for (int k = 0; k < n; k++) sortDiagonal(result, k, 0, true);
        for (int k = 1; k < n; k++) sortDiagonal(result, 0, k, false);
        
        return result;
    }
    
    private void sortDiagonal(int[][] grid, int row, int col, boolean reverse) {
        List<Integer> diagonal = new ArrayList<>();
        for (int r = row, c = col; r < grid.length && c < grid.length; r++, c++) diagonal.add(grid[r][c]);
        Collections.sort(diagonal, reverse ? Collections.reverseOrder() : null);
        for (int i = 0; row < grid.length && col < grid.length; row++, col++) grid[row][col] = diagonal.get(i++);
    }
}
