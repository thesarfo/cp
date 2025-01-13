class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> res = new ArrayList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int row = 0;
        boolean rg = true; 
    
        while (row < rows) {
            if (rg) {
                for (int col = 0; col < cols; col++) if ((row + col) % 2 == 0)res.add(grid[row][col]);
            } else {
                for (int col = cols - 1; col >= 0; col--) if ((row + col) % 2 == 0) res.add(grid[row][col]);
            }
            row++;
            rg = !rg;
        }    
        return res;
    }
}