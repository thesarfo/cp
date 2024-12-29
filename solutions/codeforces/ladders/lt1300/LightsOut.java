import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[][] grid = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = s.nextInt();
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int toggleCount = grid[i][j]; 
               
                if (i > 0) toggleCount += grid[i-1][j]; 
                if (i < 2) toggleCount += grid[i+1][j]; 
                if (j > 0) toggleCount += grid[i][j-1]; 
                if (j < 2) toggleCount += grid[i][j+1]; 
                
                System.out.print(toggleCount % 2 == 0 ? "1" : "0");
            }
            System.out.println(); 
        }

        s.close();
    }
}
