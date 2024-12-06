We are given a sorted array of integers and a target value, and our task is to find the first and last position of the target in the array. If the target isn't in the array, we need to return [-1, -1]. The challenge is that the array is sorted, and we need an efficient solution with a time complexity of `O(log n)`.

[Leetcode 34](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

**Key Insights**
1. **Binary Search**: Since the array is sorted, a binary search is a great choice. Binary search has a time complexity of O(log n), which meets the problem's requirement.

2. **First and Last Position**: The idea is to use binary search to find the first and last occurrence of the target:
* The first occurrence can be found by modifying the binary search to continue searching on the left side even after finding the target.
* The last occurrence can be found by continuing to search on the right side even after finding the target.

**Plan**
* We will perform binary search to find the *first* position of the target. After finding it, we’ll continue checking the left side to make sure it's the first occurrence.

* Then, we'll perform binary search again to find the last position, continuing the search to the right side to ensure it’s the last occurrence.

Also, we can handle edge cases such as:
* An empty array
* The target not being found at all

The solution would look like this 

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};  // Default result if the target is not found.
        
        // Edge case: if the array is empty.
        if (nums.length == 0) {
            return res;
        }

        // Find the first position of the target
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;  // To avoid overflow
            if (nums[mid] == target) {
                res[0] = mid;
                right = mid - 1;  // Continue searching on the left side to find the first occurrence
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // If no occurrence is found, return [-1, -1]
        if (res[0] == -1) {
            return res;
        }

        // Find the last position of the target
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                res[1] = mid;
                left = mid + 1;  // Continue searching on the right side to find the last occurrence
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }
}
```