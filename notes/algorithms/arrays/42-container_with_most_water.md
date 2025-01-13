Given an array `height[]` of size \( n \), find two lines that, along with the x-axis, form a container. The container should hold the **maximum water**.

[Leetcode Problem](https://leetcode.com/problems/container-with-most-water/)

### Key Formula
To calculate the water between two lines at indices `i` and `j`:  
\[
\text{Water} = (\text{j} - \text{i}) \times \min(\text{height[i]}, \text{height[j]})
\]


#### 1. **Brute Force (Nested Loops)**
- **Idea:** Compare every pair of lines.  
  - Calculate water for all possible pairs using the formula.
  - Keep track of the maximum water.

#### Code:
```java
class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int water = (j - i) * Math.min(height[i], height[j]);
                maxWater = Math.max(maxWater, water);
            }
        }

        return maxWater;
    }
}
```

#### Complexity:
- **Time:** \( O(n^2) \) (Two nested loops)
- **Space:** \( O(1) \) (No extra space used)


#### 2. **Optimal Approach (Two Pointers)**
- **Idea:**  
  - Use two pointers, one at the start (`i`) and one at the end (`j`).  
  - Calculate water using the current two lines.  
  - Move the pointer pointing to the shorter line (to potentially find a taller one).  
  - Repeat until `i` and `j` meet.

#### Code:
```java
class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxWater = 0;

        while (i < j) {
            int water = (j - i) * Math.min(height[i], height[j]);
            maxWater = Math.max(maxWater, water);

            // Move the pointer pointing to the smaller height
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxWater;
    }
}
```

#### Complexity:
- **Time:** \( O(n) \) (Single pass through the array)
- **Space:** \( O(1) \) (No extra space used)



**Dry Run** <br>
**Input:** `height = [1, 4, 2, 3]`  
**Steps:**
1. Start with `i = 0`, `j = 3`:
   - Water = \( (3 - 0) \times \min(1, 3) = 3 \)
   - Move `i` since `height[i] < height[j]`.

2. Now `i = 1`, `j = 3`:
   - Water = \( (3 - 1) \times \min(4, 3) = 6 \)
   - Update `maxWater = 6`.
   - Move `j` since `height[j] < height[i]`.

3. Now `i = 1`, `j = 2`:
   - Water = \( (2 - 1) \times \min(4, 2) = 2 \)
   - `maxWater` remains 6.
   - Move `j`.

4. Stop when `i == j`.

**Output:** `6`