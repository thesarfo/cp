import java.util.*;
public class Solution {
    public static boolean searchElement(int [][]MATRIX, int target) {
        // Write your code here.
        int row = 0, col = MATRIX[0].length - 1;

        while(row < MATRIX.length && col >= 0){
            if(MATRIX[row][col] == target) return true;
            else if(MATRIX[row][col] < target) row++;
            else col--;
        }
        return false;
    }
}