import java.util.ArrayList;

public class Solution {
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
        int numRows = mat.size();
        int numCols = mat.get(0).size();
        int left = 0, right = numRows * numCols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / numCols;
            int col = mid % numCols;

            if (mat.get(row).get(col) == target) return true;
            else if (mat.get(row).get(col) < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
