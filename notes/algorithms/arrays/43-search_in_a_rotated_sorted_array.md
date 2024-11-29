
**Problem Statement**
You are given a rotated sorted array and an integer `target`. Your task is to determine if `target` exists in the array and return its index. If it does not exist, return `-1`.

[LeetCode 33](https://leetcode.com/problems/search-in-rotated-sorted-array/).


### Example:
**Input**:  
`nums = [4,5,6,7,0,1,2], target = 0`  
**Output**:  
`4`

**Input**:  
`nums = [4,5,6,7,0,1,2], target = 3`  
**Output**:  
`-1`


## **Approach**

To solve this problem, we can modify the binary search algorithm to account for the rotation in the array.

### **Steps to Solve**

1. **Identify the Sorted Half**:
   - Compare `nums[low]` with `nums[mid]` to determine which half is sorted:
     - If `nums[low] <= nums[mid]`: The **left half** is sorted.
     - Otherwise, the **right half** is sorted.

2. **Target in Sorted Half?**
   - If the left half is sorted:
     - Check if the target lies within the range of the sorted left half:
       - `nums[low] <= target && target <= nums[mid]`: The target is in the left half.
       - Otherwise, it’s in the right half.
   - If the right half is sorted:
     - Check if the target lies within the range of the sorted right half:
       - `nums[mid] <= target && target <= nums[high]`: The target is in the right half.
       - Otherwise, it’s in the left half.

3. **Update Search Bounds**:
   - Adjust `low` and `high` pointers based on whether the target lies in the left or right half.

---

## **Code Implementation**

```cpp
class Solution {
public:
    int search(vector<int>& nums, int target) {
        int low = 0, high = nums.size() - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Check if mid is the target
            if (nums[mid] == target) return mid;
            
            // Identify if the left half is sorted
            if (nums[low] <= nums[mid]) {
                // Check if the target lies in the sorted left half
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1; // Narrow search to the left
                } else {
                    low = mid + 1; // Narrow search to the right
                }
            } else { // Right half is sorted
                // Check if the target lies in the sorted right half
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1; // Narrow search to the right
                } else {
                    high = mid - 1; // Narrow search to the left
                }
            }
        }
        
        return -1; // Target not found
    }
};
```


**Key Insights**

1. **Understanding Rotated Sorted Array**:
   - A rotated sorted array has one unsorted part due to the rotation. Our task is to find which part (left or right) is sorted to determine where to search.

2. **Binary Search Logic**:
   - Normally, binary search reduces the search space by half. Here, we extend it to handle the rotated condition by checking which part of the array is sorted.

3. **Edge Cases**:
   - Target not present in the array.
   - Arrays with no rotation (`nums` is completely sorted).
   - Arrays with minimal elements (size 1 or 2).



- **Time Complexity**: `O(log n)`
  - We reduce the search space by half at each step.
- **Space Complexity**: `O(1)`
  - No additional space is used.