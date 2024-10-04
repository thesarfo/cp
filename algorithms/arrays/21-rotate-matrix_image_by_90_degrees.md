You are given an `n x n` matrix, i.e a square matrix. Your task is to rotate it in the clockwise direction by 90 degrees.

[Leetcode 48](https://leetcode.com/problems/rotate-image/description/)

---

1. **Brute Force Solution**: We are given an `n x n` matrix, and our task is to rotate it clockwise by 90 degrees. The idea is to create an empty matrix and map each element from the input matrix to the correct position in the output matrix.

Let's use the example matrix:

```
Input Matrix:          Output Matrix:
[ 1,  2,  3,  4]      [13,  9,  5,  1]
[ 5,  6,  7,  8]  ->  [14, 10,  6,  2]
[ 9, 10, 11, 12]      [15, 11,  7,  3]
[13, 14, 15, 16]      [16, 12,  8,  4]
```

Let's now map each element from the input matrix to its corresponding position in the output matrix:

- **First row of input** maps to **last column of output**:
    - `input[0][0] = 1` goes to `output[0][3] = 1`
    - `input[0][1] = 2` goes to `output[1][3] = 2`
    - `input[0][2] = 3` goes to `output[2][3] = 3`
    - `input[0][3] = 4` goes to `output[3][3] = 4`

- **Second row of input** maps to **second-last column of output**:
    - `input[1][0] = 5` goes to `output[0][2] = 5`
    - `input[1][1] = 6` goes to `output[1][2] = 6`
    - `input[1][2] = 7` goes to `output[2][2] = 7`
    - `input[1][3] = 8` goes to `output[3][2] = 8`

- **Third row of input** maps to **third-last column of output**:
    - `input[2][0] = 9` goes to `output[0][1] = 9`
    - `input[2][1] = 10` goes to `output[1][1] = 10`
    - `input[2][2] = 11` goes to `output[2][1] = 11`
    - `input[2][3] = 12` goes to `output[3][1] = 12`

- **Fourth row of input** maps to **first column of output**:
    - `input[3][0] = 13` goes to `output[0][0] = 13`
    - `input[3][1] = 14` goes to `output[1][0] = 14`
    - `input[3][2] = 15` goes to `output[2][0] = 15`
    - `input[3][3] = 16` goes to `output[3][0] = 16`

### General Mapping:
For an `n x n` matrix, each element `input[i][j]` is mapped to the position `output[j][n-1-i]`. This general formula works for any `n`-dimensional matrix.

Below is a pseudocode for this implementation

```java
ans[n][m]

for(i = 0 -> n){
    for(j = 0 -> n){
        ans[j][n-1-i] = matrix[i][j]
    }
}
```

Below is a java implementation

```java
class Solution {
    public int[][] rotate(int[][] matrix) {
        int n = matrix.length; 
        int[][] ans = new int[n][n]; 

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][n - 1 - i] = matrix[i][j]; 
            }
        }
        return ans; 
    }
}

```

The time complexity of this solution is 0(n2) where n is the number of rows (or columns) in the matrix. This is because we loop over all the elements in the matrix, which takes n×n operations.

---

Your notes for the optimized solution are almost perfect! I'll fine-tune them for clarity and add a detailed explanation using the example matrix for reference:

---

2. **Optimized Solution**

To rotate the matrix **in-place** (without using an additional matrix), we can break down the operation into two steps: **transposing the matrix** and then **reversing each row**.

1. **Transpose the Matrix**: In a transpose operation, the element at position `(i, j)` swaps with the element at `(j, i)`. Essentially, the rows become columns and the columns become rows. The diagonal elements remain in their original positions, while all the other elements are mirrored across the diagonal.

2. **Reverse Each Row**: After transposing, we reverse every row to complete the 90-degree clockwise rotation.

#### How Transposition Works:
Let's take the matrix example:

```
Input Matrix:
[ 1,  2,  3,  4]
[ 5,  6,  7,  8]
[ 9, 10, 11, 12]
[13, 14, 15, 16]
```

**After Transposing**, the matrix becomes:

```
[ 1,  5,  9, 13]
[ 2,  6, 10, 14]
[ 3,  7, 11, 15]
[ 4,  8, 12, 16]
```

- The element at `[0][1]` moves to `[1][0]`.
- The element at `[0][2]` moves to `[2][0]`.
- The element at `[1][2]` moves to `[2][1]`.
  
Notice that the diagonal elements (`[0][0]`, `[1][1]`, `[2][2]`, `[3][3]`) remain in their original positions.

#### How Row Reversing Works:
After transposing, we **reverse each row** to achieve the 90-degree rotation.

**After Reversing Each Row**, the matrix becomes:

```
[13,  9,  5,  1]
[14, 10,  6,  2]
[15, 11,  7,  3]
[16, 12,  8,  4]
```

This is the matrix rotated 90 degrees clockwise.

#### Pseudocode:
Below is the pseudocode for transposing the matrix:

```java
function rotate(matrix):
    n = length(matrix)  // Get the number of rows/columns in the matrix
    
    // Step 1: Transpose the matrix
    for i from 0 to n - 1:
        for j from i + 1 to n - 1:
            // Swap elements at positions (i, j) and (j, i)
            temp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = temp

    // Step 2: Reverse each row
    for i from 0 to n - 1:
        reverseRow(matrix[i])

// Helper function to reverse a row
function reverseRow(row):
    start = 0
    end = length(row) - 1
    while start < end:
        // Swap elements at start and end
        temp = row[start]
        row[start] = row[end]
        row[end] = temp
        start = start + 1
        end = end - 1

```

- **First loop (i)**: Controls the row index. It runs until `n - 2` to avoid re-transposing elements that are already swapped.
- **Second loop (j)**: Starts from `i + 1` and runs until `n - 1`. This ensures we only swap elements above the diagonal (to avoid redundant swaps).

After transposing, reverse each row to complete the rotation.

---

This approach avoids the need for an auxiliary matrix and performs the rotation in place with an **O(n^2)** time complexity, where `n` is the size of the matrix.

Below will be a java implementation

```java
// Function to rotate the matrix by 90 degrees clockwise
public void rotate(int[][] matrix) {
    int n = matrix.length;
    
    // Step 1: Transpose the matrix
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            // Swap elements at positions (i, j) and (j, i)
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }
    
    // Step 2: Reverse each row
    for (int i = 0; i < n; i++) {
        reverseRow(matrix[i]);
    }
}

// Helper function to reverse a row in the matrix
private void reverseRow(int[] row) {
    int start = 0;
    int end = row.length - 1;
    while (start < end) {
        // Swap elements at start and end
        int temp = row[start];
        row[start] = row[end];
        row[end] = temp;
        start++;
        end--;
    }
}

```

The TC of the transposition is 0(n / 2 * n / 2) and the reverse row is 0(n / 2). And it doesnt use any extra space.