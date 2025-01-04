class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                int top = (i > 0) ? mat[i - 1][j] : - 1;
                int bottom = (i < rows - 1) ? mat[i + 1][j] : -1;
                int left = (j > 0) ? mat[i][j - 1] : -1;
                int right = (j < cols - 1) ? mat[i][j + 1] : -1;

                if (mat[i][j] > top && mat[i][j] > bottom && mat[i][j] > left && mat[i][j] > right) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }
}