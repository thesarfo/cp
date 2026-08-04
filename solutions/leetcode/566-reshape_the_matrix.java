class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] res = new int[r][c];
        int cols = mat[0].length;
        int rows = mat.length;

        if(rows * cols != r * c)return mat;

        for (int i = 0; i < rows * cols; i++) {
            res[i / c][i % c] = mat[i / cols][i % cols];
        }

        return res;
    }
}
