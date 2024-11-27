In this problem, you're given a **mountain array**, which is defined as:
- An array that **strictly increases** to a peak and then **strictly decreases** after the peak.
- For example: `[0, 2, 4, 6, 5, 3, 1]`.

Your task is to find the **index** of the peak element (the highest value in the array). 

The mountain array guarantees that:
- There is exactly one peak, so the solution is well-defined.

[Leetcode 852](https://leetcode.com/problems/peak-index-in-a-mountain-array/description/)

### Key Insights

1. **Binary Search:** 
   - The problem requires `O(log n)` time complexity, which suggests **binary search** is a good fit.
   - We don’t need to check neighbors on both sides of the peak since the array's structure allows us to deduce where the peak lies based on the slope.

2. **Using the Slope:**
   - If `nums[mid] < nums[mid + 1]`, we are on the **uphill** slope, so the peak must be on the **right** side of `mid`.
   - If `nums[mid] > nums[mid + 1]`, we are on the **downhill** slope, so the peak must be on the **left** side or at `mid`.

3. **Mountain Array Guarantee:**
   - Since the array is guaranteed to have one peak, narrowing down the search space using the slope ensures we will find the peak index.

---

### Approach

We'll perform binary search:
1. Start with `left = 0` and `right = nums.length - 1`.
2. At each step, calculate `mid = left + (right - left) / 2`.
3. Use the slope logic:
   - If `nums[mid] < nums[mid + 1]`, move `left` to `mid + 1`.
   - If `nums[mid] > nums[mid + 1]`, move `right` to `mid`.
4. Stop when `left == right`, and return `left` (or `right`).

---

### Solution Code

```java
class Solution {
    public int peakIndexInMountainArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                // We are on the uphill, move right
                left = mid + 1;
            } else {
                // We are on the downhill, move left
                right = mid;
            }
        }

        // When left == right, we have found the peak index
        return left;
    }
}
```

---

### Step-by-Step Walkthrough

#### Example 1:
```java
nums = [0, 2, 4, 6, 5, 3, 1]
```

- **Initialization:**
  - `left = 0`, `right = 6`.
- **Iteration 1:**
  - `mid = (0 + 6) / 2 = 3`, `nums[mid] = 6`, `nums[mid + 1] = 5`.
  - Since `nums[mid] > nums[mid + 1]`, move `right = mid = 3`.
- **Iteration 2:**
  - `mid = (0 + 3) / 2 = 1`, `nums[mid] = 2`, `nums[mid + 1] = 4`.
  - Since `nums[mid] < nums[mid + 1]`, move `left = mid + 1 = 2`.
- **Iteration 3:**
  - `mid = (2 + 3) / 2 = 2`, `nums[mid] = 4`, `nums[mid + 1] = 6`.
  - Since `nums[mid] < nums[mid + 1]`, move `left = mid + 1 = 3`.
- **Result:**
  - `left == right == 3`, return `3`.

---

### Complexity Analysis

- **Time Complexity:** `O(log n)`
  - The range of the search is halved in each iteration, leading to logarithmic complexity.
- **Space Complexity:** `O(1)`
  - No additional space is used.

---

### Why This Works

1. The **mountain array guarantee** ensures that there is exactly one peak, so binary search is always valid.
2. The slope logic (`nums[mid] < nums[mid + 1]` for uphill, `nums[mid] > nums[mid + 1]` for downhill) ensures that the peak is never skipped.
3. Convergence (`left == right`) happens exactly at the peak due to the array's unique structure.

---

### Key Takeaways

- The problem is similar to the "Find Peak Element" problem (Leetcode 162) but with the added guarantee of a single peak in the mountain array.
- The binary search approach leverages the mountain array's structure and efficiently narrows down the search range using the slope.
- Simple logic (`left = mid + 1` for uphill and `right = mid` for downhill) ensures correctness and clarity.