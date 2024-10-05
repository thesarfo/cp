import java.util.*; 
import java.io.*; 

public class Solution {
    public static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, Integer n, Integer m) {
        List<Integer> row = new ArrayList<>(Collections.nCopies(n, 0));
        List<Integer> col = new ArrayList<>(Collections.nCopies(m, 0));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    row.set(i, 1); 
                    col.set(j, 1); 
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row.get(i) == 1 || col.get(j) == 1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }

        return matrix; 
    }
}
