class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++){
            int index = binarySearch(matrix[i], target);
            if(index != -1){ // if the bs didnt return -1, it means the target is at this particular index in the current row
                return true;
            }
        }
        return false;
    }

    public int binarySearch(int[] arr, int target){
        int low = 0, high = arr.length - 1;

        while(low <= high){
            int mid = (low + high) / 2;

            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}