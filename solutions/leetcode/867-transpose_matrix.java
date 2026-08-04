class Solution {
    public int[][] transpose(int[][] matrix) {
        int[][] res = new int[matrix[0].length][matrix.length];

        for(int r = 0; r < matrix[0].length; r++){
            for(int c = 0; c < matrix.length; c++){
                res[r][c] = matrix[c][r];
            }
        }

        return res;
    }
}
