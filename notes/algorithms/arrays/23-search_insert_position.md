Given a **sorted array** of distinct integers and a target value, the goal is to return the **index** of the target if found. If not, return the index where the target would be inserted to maintain the sorted order. 

[Leetcode 35](https://leetcode.com/problems/search-insert-position/description/)

### Key Constraints:
- The array is sorted in **ascending order**.
- The array contains **distinct** integers.
- You are required to implement an algorithm with **O(log n)** runtime complexity, indicating the use of **binary search**.

### Example:
1. **Input**: `nums = [1, 3, 5, 6]`, `target = 5`
   - **Output**: `2` (as `5` is found at index `2`)
   
2. **Input**: `nums = [1, 3, 5, 6]`, `target = 2`
   - **Output**: `1` (as `2` would be inserted at index `1` to keep the array sorted)
   
3. **Input**: `nums = [1, 3, 5, 6]`, `target = 7`
   - **Output**: `4` (as `7` would be inserted at index `4`)

### Approach:

We can use **binary search** to achieve the required \(O(\log n)\) time complexity. The idea is to keep narrowing the search range based on whether the target is greater or smaller than the middle element. When the loop terminates, the `left` pointer will indicate the position where the target can be inserted.

### Algorithm:
1. **Initialize Two Pointers**:
   - `left = 0` (start of the array)
   - `right = nums.length - 1` (end of the array)

2. **Binary Search**:
   - While `left <= right`, calculate the middle index `mid`.
   - If `nums[mid] == target`, return `mid`.
   - If `nums[mid] < target`, move `left` to `mid + 1` (i.e., search the right half).
   - If `nums[mid] > target`, move `right` to `mid - 1` (i.e., search the left half).

3. **Return Insertion Point**:
   - When the target is not found, the `left` pointer will indicate the position where the target should be inserted to maintain the sorted order.

### Code:

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoid overflow in large arrays
            if (nums[mid] == target) {
                return mid; // Target found, return its index
            } else if (nums[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }
        return left; // Return the index where the target would be inserted
    }
}
```

### Time Complexity:
- **Time Complexity**: \( O(\log n) \) — Each iteration of the loop reduces the search space by half, making this a logarithmic solution.
- **Space Complexity**: \( O(1) \) — No additional space is required beyond the input array.

### Explanation of Key Parts:
1. **Binary Search**: The key to solving this problem efficiently is using **binary search** since the array is sorted. Binary search splits the array into halves and narrows down the search space, which reduces the time complexity to \(O(\log n)\).
   
2. **Return `left` Pointer**: After the binary search finishes, if the target is not found, the `left` pointer will point to the index where the target can be inserted to maintain the sorted order.

### Example Walkthrough:

1. **Example 1:**
   - Input: `nums = [1, 3, 5, 6]`, `target = 5`
   - Initial `left = 0`, `right = 3`
   - First iteration: `mid = (0 + 3) / 2 = 1` → `nums[mid] = 3`, target is greater, so `left = mid + 1 = 2`
   - Second iteration: `mid = (2 + 3) / 2 = 2` → `nums[mid] = 5`, target found → return `2`

2. **Example 2:**
   - Input: `nums = [1, 3, 5, 6]`, `target = 2`
   - Initial `left = 0`, `right = 3`
   - First iteration: `mid = (0 + 3) / 2 = 1` → `nums[mid] = 3`, target is smaller, so `right = mid - 1 = 0`
   - Second iteration: `mid = (0 + 0) / 2 = 0` → `nums[mid] = 1`, target is greater, so `left = mid + 1 = 1`
   - Target not found, return `left = 1`

3. **Example 3:**
   - Input: `nums = [1, 3, 5, 6]`, `target = 7`
   - Initial `left = 0`, `right = 3`
   - First iteration: `mid = (0 + 3) / 2 = 1` → `nums[mid] = 3`, target is greater, so `left = mid + 1 = 2`
   - Second iteration: `mid = (2 + 3) / 2 = 2` → `nums[mid] = 5`, target is greater, so `left = mid + 1 = 3`
   - Third iteration: `mid = (3 + 3) / 2 = 3` → `nums[mid] = 6`, target is greater, so `left = mid + 1 = 4`
   - Target not found, return `left = 4`


### Summary:
This problem uses **binary search** to efficiently find the target index or the appropriate insertion index in a sorted array. The solution runs in \(O(\log n)\) time due to the nature of binary search and has constant space complexity.