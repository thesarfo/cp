import java.util.ArrayList;

public class Solution {
    public static int rowMaxOnes(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        int maxCount = -1; 
        int rowIndex = -1; 
        for (int i = 0; i < n; i++) {
            int firstOneIndex = lowerBound(mat.get(i), m, 1); 
            if (firstOneIndex != m) { 
                int countOnes = m - firstOneIndex; 
                if (countOnes > maxCount) {
                    maxCount = countOnes; 
                    rowIndex = i;        
                }
            }
        }

        return rowIndex; 
    }

    private static int lowerBound(ArrayList<Integer> row, int m, int target) {
        int low = 0, high = m - 1, ans = m;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (row.get(mid) >= target) { 
                ans = mid; 
                high = mid - 1; 
            } else {
                low = mid + 1; 
            }
        }

        return ans; 
    }
}
