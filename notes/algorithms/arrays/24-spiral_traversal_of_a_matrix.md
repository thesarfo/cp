Given an `n x m` matrix, your task is to print the matrix in spiral order.

**Example**:  
For the matrix:

``` 
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9, 10, 11, 12],
  [13, 14, 15, 16]
]
```

The output in spiral order would be:  
`[1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]`

<img src="../../images/matrix traversal.png">


#### Problem Link: [LeetCode 54](https://leetcode.com/problems/spiral-matrix/description/)

#### Explanation:

Spiral matrix traversal follows a consistent pattern:  
- We print elements from the **top row** (left to right).
- Then, we print elements from the **right column** (top to bottom).
- Next, we print elements from the **bottom row** (right to left).
- Finally, we print elements from the **left column** (bottom to top).

This pattern continues in layers, moving inward, until we reach the center of the matrix, where no more spiral movement is possible.

#### Example Walkthrough:

For the example matrix:
```
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9, 10, 11, 12],
  [13, 14, 15, 16]
]
```
- **Top row**: We start at `1`, move to `2`, then `3`, and finally `4`.
- **Right column**: Next, we move downwards and print `8`, `12`, and `16`.
- **Bottom row**: Moving left, we print `15`, `14`, and `13`.
- **Left column**: Moving upwards, we print `9` and `5`.

At this point, we have completed the outermost layer. We now move to the second layer (starting at `6`).

#### Pseudocode:

The traversal can be controlled using four pointers: `top`, `bottom`, `left`, and `right`. We shrink the boundaries of these pointers as we print each layer.

```java
// Pseudocode for spiral traversal

// Step 1: Initialize boundaries
top = 0, bottom = n - 1
left = 0, right = m - 1

// Step 2: Loop through the matrix in spiral order
while (top <= bottom && left <= right) {

    // 1. Traverse the top row from left to right
    for (i = left; i <= right; i++) {
        print(matrix[top][i])
    }
    top++  // Move the top boundary down

    // 2. Traverse the right column from top to bottom
    for (i = top; i <= bottom; i++) {
        print(matrix[i][right])
    }
    right--  // Move the right boundary left

    // 3. Traverse the bottom row from right to left (if top <= bottom)
    if (top <= bottom) {
        for (i = right; i >= left; i--) {
            print(matrix[bottom][i])
        }
        bottom--  // Move the bottom boundary up
    }

    // 4. Traverse the left column from bottom to top (if left <= right)
    if (left <= right) {
        for (i = bottom; i >= top; i--) {
            print(matrix[i][left])
        }
        left++  // Move the left boundary right
    }
}

```

If `left` is smaller than `right`, then it means there are columns that can be traversed, and if the `top` is lesser than the `bottom`, there are rows that can be traversed.

Below is a sample implementation in c++

```cpp
class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        if (matrix.empty() || matrix[0].empty()) return {};

        int n = matrix.size();
        int m = matrix[0].size();
        int left = 0, right = m - 1;
        int top = 0, bottom = n - 1;
        vector<int> ans;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                ans.push_back(matrix[top][i]);
            }
            top++; 

            for (int i = top; i <= bottom; i++) {
                ans.push_back(matrix[i][right]);
            }
            right--; 

            if (top <= bottom) { 
                for (int i = right; i >= left; i--) {
                    ans.push_back(matrix[bottom][i]);
                }
                bottom--; 
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.push_back(matrix[i][left]);
                }
                left++; 
            }
        }
        return ans;
    }
};

```

#### Key Points:
- Each iteration processes the matrix in four directions: top, right, bottom, and left.
- After each pass, we update the boundaries (`top`, `bottom`, `left`, `right`) to move inward and process the next layer.
- The traversal ends when the boundaries overlap or cross each other.

