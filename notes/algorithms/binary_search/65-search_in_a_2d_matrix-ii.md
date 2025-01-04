You are given a 2D matrix where:

1. Each row is sorted in ascending order.
2. Each column is sorted in ascending order.
3. However, the first element of a row is **not necessarily greater** than the last element of the previous row.
Your task is to find the row and column coordinates of a target value.

[Leetcode Problem](https://leetcode.com/problems/search-a-2d-matrix-ii/)
[Code360 Problem](https://www.naukri.com/code360/problems/search-in-a-sorted-2d-matrix_6917532?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM)

**1. Brute Force Solution**:

We can just use a nested loop to iterate through the array and find the coordinates of the target we are looking for.

Below is a code implementation
```java
class Solution {
    public int[] searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == target){
                    return {i, j};
                }
            }
        }
        return {-1, -1};
    }
}
```

The TC of this is O(n * m) where n and m are the no. of rows and cols respectively.

This is obviously not a good solution and can be optimized further.


**2. Better Solution**
Observe that, each row has been sorted for us. So we can consider each row as a separate 1d array, and then use binary search to look for our target in each row.


Below is a code implementation
```java
class Solution {
    public int[] searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++){
            int index = binarySearch(matrix[i], target);
            if(index != -1){ // if the bs didnt return -1, it means the target is at this particular index in the current row
                return {i, index}
            }
        }
        return {-1, -1};
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
```

The TC of this is O(n) for the row traversal and binary search for each column. Therefore the overall TC is O(n * log(m)). Although its better than the brute force, we are still traversing all rows.

But it can be optimized further.

**3. Optimal Solution**:

The matrix is sorted both row and column wise, and this can be used to our advantage

1. Start at the **top right corner** of the matrix. (0, lastColumn).
2. If the current element is equal to the target, return its coordinates
3. If the current element is **smaller** than the target, move **down** to the next row
4. If the current element is **greater** move **left** to the previous column


Below is a code implementation
```java
class Solution {
    public int[] searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return new int[]{row, col};
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return new int[]{-1, -1};
    }
}
```

The TC of this is O(n + m).