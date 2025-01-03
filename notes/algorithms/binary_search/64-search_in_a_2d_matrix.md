You have been given a sorted matrix, and your task is to find out if the given `target` is in the matrix or not. If it is there, return true, if not return false.

[Search a 2d matrix (leetcode)](https://leetcode.com/problems/search-a-2d-matrix)
[Search a 2d matrix (coding ninjas)](https://www.codingninjas.com/studio/problems/search-in-a-2d-matrix_980531?utm_source=youtube&utm_medium=affiliate&utm_campaign=codestudio_Striver_BinarySeries&leftPanelTab=1)

1. **Brute Force**: We can traverse the entire 2d matrix and then check if the target is there or not.

Below is a code implementation
```java
 public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == target) return true;
            }
        }
        return false;
    }
```

The TC of this is O(n * m), where `n` is the number of rows and `m` is the number of columns. whereas the space is O(1). We can optimize this further.

2. **Better Solution - Binary Search**
Since each row of the matrix is sorted, we can optimize our search by checking the range of each row:

1. Look at the **first** and **last** elements of the current row.
    - If the `target` lies within this range, it must be in this row.
    - Otherwise, skip the row and move to the next.

2. For the identified row, use binary search to quickly find the target.

Below is a code implementation
```java
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] <= target && target <= matrix[i][matrix[i].length - 1]) {
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }

    public boolean binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; 

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
```

The TC of this is O(n) + (log m) via the iteration and the binary search, while the SC is constant. The TC is as good as O(n).

However, we can still optimize this further.

3. **Optimal Solution - Flatten the matrix into a 1d**: 
What if we can hypothetically flatten the 2d array into a 1d array, we can simply search for the target in the flattened array using binary search. We will not flatten it in the real world bcos it'll take O(n * m) but we can still do something about it. Assuming we have a `(3 * 4)` matrix, we know that the first element will have index `0` while the last element will be at index `12`. Assuming we have a 1d array from `0` to `12`, we can simply find the middle element of that and perform a binary search for our target. However, we are actually working with a 2d array, so how do we make sure that the middle index `5` is translated to a 2d coordinates.

The formula to convert an index to 2d coordinates are as follows.

- To get the row: `index / m` where `m` is the number of columns.
- To the the columns: `index % m` where `m` is the number of columns.

The intuition behind this is that if we have 4 columns, then the elements on each row will be a multiple of 4. And for the columns, we know that the element will be a modulo of 4.


Imagine "flattening" the matrix into a 1D array:

* If the matrix has `n` rows and `m` columns, a hypothetical 1D array would have `n * m` elements.

* Instead of actually flattening the matrix (which takes extra space), we can directly calculate the **row** and **column** for any 1D index using these formulas:
    * **Row**: `index / m`
    * **Column**: `index % m`
    
    Where `m` is the number of columns.

Below is a code implementation
```java
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0, high = n * m - 1;

        while(low <= high){
            int mid = (low + high) / 2;
            int row = mid / m, col = mid % m;

            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
```

The TC of this is O(log(n * m)) while the SC is O(1).