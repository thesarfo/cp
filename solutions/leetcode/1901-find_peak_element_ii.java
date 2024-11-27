class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int left = 0, right = cols - 1; 

        while(left <= right){
            int midCol = left + (right - left) / 2;

            int maxRow = 0;
            for(int row = 0; row < rows; row++){
                if(mat[row][midCol] > mat[maxRow][midCol]){
                    maxRow = row;
                }
            }
            int leftNeighbour = (midCol - 1 >= 0) ? mat[maxRow][midCol - 1]: Integer.MIN_VALUE;
            int rightNeighbour = (midCol + 1 < cols) ? mat[maxRow][midCol + 1] : Integer.MIN_VALUE;

            if(mat[maxRow][midCol] > leftNeighbour && mat[maxRow][midCol] > rightNeighbour){
                return new int[]{maxRow, midCol};
            } else if(leftNeighbour > mat[maxRow][midCol]){
                right = midCol - 1;
            } else{
                left = midCol + 1;
            }
        }

        return new int[] {-1, -1};
    }
}