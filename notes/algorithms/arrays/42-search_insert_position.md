Problem Link: [LeetCode 35](https://leetcode.com/problems/search-insert-position/)

---

### **The Problem**

You're given a sorted array `nums` and a target value `target`. Your goal is to:
- Return the index of `target` if it exists in the array.
- If `target` does not exist, return the index where it would be inserted to maintain the sorted order.

This is effectively the **lower bound problem**, where you're finding the smallest index `i` such that:

`nums[i] >= target
`

---

### **Approach: Binary Search**

Since the array is sorted, binary search helps us find the solution efficiently in \( O(\log n) \).

#### **Key Idea**
1. Use two pointers (`low` and `high`) to track the search range.
2. Repeatedly calculate the midpoint (`mid`) and compare `nums[mid]` with `target`:
   - If `nums[mid] >= target`: This means `mid` is a possible answer, but we check the left half to find a smaller valid index.
   - If `nums[mid] < target`: This means `mid` is too small, so we move to the right half.

3. When the loop ends, the position where the `target` fits is determined.

---

### **Solutions**

#### **1. Lower Bound Approach (C++ Solution)**

```cpp
class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int low = 0, high = nums.size() - 1, ans = nums.size();

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                ans = mid;  // Potential lower bound
                high = mid - 1;  // Narrow search to the left
            } else {
                low = mid + 1;  // Narrow search to the right
            }
        }
        return ans;  // `ans` holds the lower bound index
    }
};
```

**Explanation**:
1. Start with `low = 0`, `high = n - 1`, and `ans = n` (default to the size of the array).
2. At each step:
   - If `nums[mid] >= target`, update `ans = mid` because this index is a valid lower bound. Then, shift `high` to `mid - 1` to search for a smaller valid index.
   - If `nums[mid] < target`, move `low` to `mid + 1` to search in the right half.
3. After the loop ends, `ans` contains the smallest index `i` such that `nums[i] >= target`.

**Why This Works**:
- The variable `ans` explicitly tracks the potential answer, making it easy to understand how the lower bound is found.

---

#### **2. Left Return Approach (Java Solution)**

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;  // Exact match found
            } else if (nums[mid] > target) {
                right = mid - 1;  // Narrow search to the left
            } else {
                left = mid + 1;  // Narrow search to the right
            }
        }
        return left;  // `left` ends up being the insertion point
    }
}
```

**Explanation**:
1. Use `left` and `right` pointers to control the search range.
2. At each step:
   - If `nums[mid] == target`, return `mid` immediately (exact match).
   - If `nums[mid] > target`, move `right` to `mid - 1` to search in the left half.
   - If `nums[mid] < target`, move `left` to `mid + 1` to search in the right half.
3. After the loop ends, `left` naturally points to the insertion position because it converges to the first index where `nums[i] >= target`.

**Why This Works**:
- The `left` pointer effectively serves as the lower bound, so there's no need for an extra variable like `ans`.

---

### **Comparing the Two Approaches**

| **Feature**             | **Lower Bound Approach** (C++)       | **Left Return Approach** (Java)     |
|--------------------------|--------------------------------------|--------------------------------------|
| **Result Tracking**      | Uses an explicit variable `ans` to track the result. | Relies on the `left` pointer directly. |
| **Exact Match Handling** | Implicitly handled via `nums[mid] >= target`. | Explicitly checks `nums[mid] == target`. |
| **Insertion Point**      | `ans` contains the insertion index. | `left` ends up as the insertion index. |
| **Code Simplicity**      | Slightly verbose due to `ans`.       | More concise as `left` serves dual purposes. |

---

### **Example Walkthrough**

#### Input:
```plaintext
nums = [1, 3, 5, 6]
target = 5
```

#### Steps for Both Solutions:
1. **Initial Range**: `low = 0`, `high = 3`, `ans = n` (in C++), or `left = 0`, `right = 3` (in Java).
2. **First Iteration**:
   - Calculate `mid = (0 + 3) / 2 = 1`.
   - Compare `nums[1] = 3` with `target = 5`.
     - \( \text{nums[mid]} < \text{target} \), so move `low = 2` (C++) or `left = 2` (Java).
3. **Second Iteration**:
   - Calculate `mid = (2 + 3) / 2 = 2`.
   - Compare `nums[2] = 5` with `target = 5`.
     - \( \text{nums[mid]} = \text{target} \), so `ans = 2` (C++) or return `2` (Java).

#### Output:
```plaintext
2
```

---

### **Edge Cases**

1. **Target Smaller Than All Elements**:
   - Input: `nums = [2, 4, 6]`, `target = 1`
   - Output: `0` (insert at the beginning)

2. **Target Larger Than All Elements**:
   - Input: `nums = [2, 4, 6]`, `target = 10`
   - Output: `3` (insert at the end)

3. **Empty Array**:
   - Input: `nums = []`, `target = 5`
   - Output: `0` (insert as the first element)
