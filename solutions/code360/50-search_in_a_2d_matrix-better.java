import java.util.ArrayList;

public class Solution {
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
        for (int i = 0; i < mat.size(); i++) {
            if (mat.get(i).get(0) <= target && target <= mat.get(i).get(mat.get(i).size() - 1)) {
                return binarySearch(mat.get(i), target);
            }
        }
        return false;
    }

    static boolean binarySearch(ArrayList<Integer> row, int target) {
        int left = 0, right = row.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (row.get(mid) == target) return true;
            else if (row.get(mid) > target) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
}
