You are given a 2D matrix where:
1. No two adjacent cells can have the same value.
2. A **peak element** is an element that is strictly greater than its **top**, **bottom**, **left**, and **right** neighbors.
3. If the element is at the edge of the matrix, assume the missing sides have a value of `-1`.

Your task is to find and return **any one peak element**.

[Leetcode Problem](https://leetcode.com/problems/find-a-peak-element-ii/description/)

### **Example**  

**Input**:  
```text
matrix = [
  [1, 4, 3],
  [6, 7, 8],
  [2, 5, 9]
]
```

**Output**:  
```text
[1, 2]  (or [2, 2], or [1, 1]—any valid peak)
```

**Explanation**:  
- `8` at `[1, 2]` is a peak because it is greater than its neighbors `7`, `4`, and `9`.  
- Other valid peaks include `7` at `[1, 1]` or `9` at `[2, 2]`.

---

### **1. Brute Force Solution**

#### **Steps**:
1. Traverse through every element in the matrix.
2. For each element, compare it to its **top**, **bottom**, **left**, and **right** neighbors.
3. Return the first element that satisfies the peak condition.

#### **Code Implementation**:
```java
class Solution {
    public int[] findPeakElement(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int top = (i > 0) ? matrix[i - 1][j] : -1;
                int bottom = (i < rows - 1) ? matrix[i + 1][j] : -1;
                int left = (j > 0) ? matrix[i][j - 1] : -1;
                int right = (j < cols - 1) ? matrix[i][j + 1] : -1;

                if (matrix[i][j] > top && matrix[i][j] > bottom && matrix[i][j] > left && matrix[i][j] > right) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1}; // No peak found (shouldn't happen as per problem description)
    }
}
```

#### **Analysis**:
- **Time Complexity**: (O(n * m)), where `n` is the number of rows and `m` is the number of columns.
- **Space Complexity**: `O(1)`.
- **Intuition**: Straightforward but checks every element.

---

### **2. Optimal Solution (Binary Search on Columns)**

#### **Intuition**:  
The matrix behaves like a 2D "mountain range."  
1. In a **1D array**, the peak is where the values increase and then decrease.  
2. In a **2D matrix**, the same idea applies, but we need to identify the column or row where the "peak" is most likely located.  

We use **binary search** on columns to eliminate unnecessary sections of the matrix.

#### **Steps**:
1. Start with two pointers: `low = 0` and `high = cols - 1` (first and last columns).
2. Find the **middle column** (`mid`).
3. Identify the row (`maxRow`) with the maximum value in this column. note that the maximum value is likely to be the peak element
4. Check if this maximum value is a peak:
   - Compare it with its neighbors (`left` and `right`).
5. If it’s not a peak:
   - If `left` is greater, move to the left half (`high = mid - 1`).
   - If `right` is greater, move to the right half (`low = mid + 1`).
6. Repeat until a peak is found.

---

#### **Code Implementation**:
```java
class Solution {
    public int[] findPeakElement(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int low = 0, high = cols - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Find the maximum element in the middle column
            int maxRow = 0;
            for (int i = 1; i < rows; i++) {
                if (matrix[i][mid] > matrix[maxRow][mid]) {
                    maxRow = i;
                }
            }

            // Check if the element is a peak
            int left = (mid > 0) ? matrix[maxRow][mid - 1] : -1;
            int right = (mid < cols - 1) ? matrix[maxRow][mid + 1] : -1;

            if (matrix[maxRow][mid] > left && matrix[maxRow][mid] > right) {
                return new int[]{maxRow, mid};
            }

            // Move to the side with a higher neighbor
            if (left > matrix[maxRow][mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new int[]{-1, -1}; // No peak found
    }
}
```

---

#### **Example Walkthrough**:
For the input:  
```text
matrix = [
  [1, 4, 3],
  [6, 7, 8],
  [2, 5, 9]
]
```

1. Start with `low = 0`, `high = 2` (columns).  
2. `mid = 1` (middle column):  
   - Column 1: `4`, `7`, `5`. Maximum is `7` at row 1.
3. Check neighbors of `7`:  
   - `Left (6)`, `Right (8)`.  
   - `7` is not a peak because `8 > 7`. Move right (`low = mid + 1`).
4. `low = 2`, `high = 2`:  
   - Column 2: `3`, `8`, `9`. Maximum is `9` at row 2.
5. Check neighbors of `9`:  
   - `Left (5)`.  
   - `9` is a peak because it’s greater than all neighbors.
6. Return `[2, 2]`.

---

#### **Analysis**:
- **Time Complexity**: `O(n * log(m))`.
  - Finding the maximum in a column: `O(n)`.
  - Binary search on columns: `O(log(m))`
- **Space Complexity**: `O(1)`