class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        List<Integer> values = new ArrayList<>();
        int n = grid.length;
        
        for (int i = 0; i < n; i++) {
            Arrays.sort(grid[i]); 
            for (int j = grid[i].length - 1, count = 0; j >= 0 && count < limits[i]; j--, count++) {
                values.add(grid[i][j]);
            }
        }
        
        Collections.sort(values, Collections.reverseOrder()); 
        
        long sum = 0;
        for (int i = 0; i < Math.min(k, values.size()); i++) {
            sum += values.get(i);
        }
        
        return sum;
    }
}
