class Solution {
    public int minimumOperations(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int slp = 0;
        
        for (int j = 0; j < n; j++) slp += cim(grid, j);
        return slp;
    }
    
    private int cim(int[][] grid, int col) {
        int m = grid.length;
        int pox = 0;
        for (int i = 1; i < m; i++) {
            int vrp = grid[i-1][col];
            int rtv = grid[i][col];
            if (rtv <= vrp) {
                int imt = vrp - rtv + 1;
                pox += imt;
                rtv = vrp + 1;
            }
        }
        return pox;
    }
}