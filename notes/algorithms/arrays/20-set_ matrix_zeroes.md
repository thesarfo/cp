You are given an `n*m` matrix containing `0`s and `1`s. Your task is to find all the zeroes in the matrix, and for each zero, mark all the elements in the same row and column as `0`.

[Leetcode 73](https://leetcode.com/problems/set-matrix-zeroes/description/)

### 1. **Brute Force Approach**
A simple solution is to iterate through the matrix and, for every `0`, update all elements in its row and column to `0`. But is this correct? Let’s think about it: During the first pass, some `1`s might turn into `0`s just because they happen to be in the same row or column as an original `0`. This will create more `0`s in the matrix, causing us to unnecessarily update additional rows and columns in subsequent iterations.

A way to fix this issue is to temporarily mark elements that are supposed to be changed to `0` with a different value, say `-1`, during the first pass. Then, after the iteration, we can convert all `-1`s to `0`s in a second pass.

#### Pseudocode:

```java
for (i = 0; i < n; i++) {
    for (j = 0; j < m; j++) {
        if (arr[i][j] == 0) {
            markRow(i);
            markCol(j);
        }
    }
}

markRow(i) {
    for (j = 0; j < m; j++) {
        if (arr[i][j] != 0) {
            arr[i][j] = -1;
        }
    }
}

markCol(j) {
    for (i = 0; i < n; i++) {
        if (arr[i][j] != 0) {
            arr[i][j] = -1;
        }
    }
}

for (i = 0; i < n; i++) {
    for (j = 0; j < m; j++) {
        if (arr[i][j] == -1) {
            arr[i][j] = 0;
        }
    }
}
```

While this works, the time complexity is `(n * m) * (n + m) + (n * m)`, which isn't efficient for large matrices. Let's find a better solution.

### 2. **Better Approach**
The inefficiency of the brute force solution arises from the repeated updates to the matrix. Instead of immediately updating rows and columns when we find a `0`, we can use two auxiliary arrays: 
- A `row[]` array of size `n` to mark which rows need to be zeroed.
- A `col[]` array of size `m` to mark which columns need to be zeroed.

Initially, both arrays are filled with `0`. When we find a `0` at position `(i, j)`, we set `row[i] = 1` and `col[j] = 1`. Once the marking is done, we perform a second pass through the matrix, zeroing out elements in rows or columns that are marked.

#### Pseudocode:

```java
int row[n] = {0}; // Track which rows to zero
int col[m] = {0}; // Track which columns to zero

// First pass: Mark the rows and columns
for (i = 0; i < n; i++) {
    for (j = 0; j < m; j++) {
        if (arr[i][j] == 0) {
            row[i] = 1;
            col[j] = 1;
        }
    }
}

// Second pass: Set elements to zero based on markers
for (i = 0; i < n; i++) {
    for (j = 0; j < m; j++) {
        if (row[i] == 1 || col[j] == 1) {
            arr[i][j] = 0;
        }
    }
}
```

Below is a java implementation of the above approach

```java
class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] row = new int[n];
        int[] col = new int[m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(row[i] == 1 || col[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
```

This approach improves the time complexity to `O(n * m)` and reduces the space complexity to `O(n + m)`, making it much more efficient. But there is still a better way

### 3. **Optimal Solution**: 
The better solution was good, but it uses extra space that we can try to optimize. Instead of creating an array to hold the row and columns, we can move the arrays into the matrix itself(in place). since 0, 0 will overlapwith both in place arrays we can create a variable to hold that value. and we simply do the second solution