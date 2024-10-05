public class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        health -= grid.get(0).get(0);
        if (health <= 0) return false;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, health});
        
        int[][] maxHealth = new int[m][n];
        for (int[] row : maxHealth) Arrays.fill(row, -1);
        maxHealth[0][0] = health;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int currentHealth = current[2];
            
            if (x == m - 1 && y == n - 1 && currentHealth >= 1) {
                return true;
            }
            
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                
                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    int newHealth = currentHealth - grid.get(newX).get(newY);
                    
                    if (newHealth > maxHealth[newX][newY]) {
                        maxHealth[newX][newY] = newHealth;
                        queue.add(new int[] {newX, newY, newHealth});
                    }
                }
            }
        }
        
        return false;
    }
}