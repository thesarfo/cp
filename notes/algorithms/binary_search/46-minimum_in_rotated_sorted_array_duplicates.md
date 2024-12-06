In a rotated sorted array with distinct values, you can usually identify which part of the array is sorted and use binary search to find the minimum. However, when the array contains **duplicates**, the usual approach breaks down because we can't always distinguish which part of the array is sorted just by comparing the `low`, `mid`, and `high` values (since `nums[low] == nums[mid] == nums[high]` might happen).

[Leetcode 154](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/)

In this case, the idea is to use **binary search** but handle the duplicates carefully:

1. **Sorted Rotated Array Property**:
   - The array is sorted in ascending order and then rotated. After the rotation, one part of the array will still be sorted.
   - We can usually figure out which half is sorted by comparing `nums[mid]` with `nums[low]` and `nums[high]`.
   
2. **Handling Duplicates**:
   - If `nums[mid] == nums[high]`, we cannot reliably determine which side is sorted because duplicates can cause `mid` and `high` to be equal, even if one of the halves is unsorted.
   - In this case, we **decrease `high`** by one to reduce the search space, ensuring that we are still making progress (since the minimum element must be in the remaining part of the array).

3. **Binary Search Approach**:
   - If `nums[mid] <= nums[high]`, this means the right half is sorted, and the minimum must be in the left half. Hence, we set `high = mid`.
   - Otherwise, if `nums[mid] > nums[high]`, the minimum must be in the right half, and we set `low = mid + 1`.

4. **Termination**:
   - The loop continues until `low == high`, at which point `low` (or `high`) will point to the minimum element.

### Code Breakdown

```python
class Solution(object):
    def findMin(self, nums):
        low, high = 0, len(nums) - 1

        while low < high:
            mid = (low + high) // 2

            if nums[mid] == nums[high]:
                # If mid and high are equal, we cannot determine the sorted half,
                # so we move high to the left
                high -= 1
            elif nums[mid] <= nums[high]:
                # If the right half is sorted, then the minimum element must be on the left
                high = mid
            else:
                # If the left half is sorted, the minimum element is on the right
                low = mid + 1
        
        return nums[low]
```

### Step-by-Step Explanation:

1. **Initialize `low` and `high`**:
   - `low` is set to the beginning of the array (`0`).
   - `high` is set to the end of the array (`len(nums) - 1`).

2. **While loop**:
   - The loop continues until `low` is equal to `high`. This means the search space has been narrowed down to one element, which is the minimum.

3. **First condition (`nums[mid] == nums[high]`)**:
   - If the middle element (`nums[mid]`) is equal to the last element (`nums[high]`), we cannot confidently decide which half is sorted because the duplicate values may appear at both ends. 
   - So, to make progress and reduce the search space, we decrease `high` by one. This guarantees that we keep searching in the remaining space.

4. **Second condition (`nums[mid] <= nums[high]`)**:
   - If `nums[mid]` is less than or equal to `nums[high]`, it means the right half is sorted because the rightmost element is greater than or equal to the middle element.
   - Since the array is rotated, the minimum value must lie in the unsorted left half. Therefore, we set `high = mid`.

5. **Else condition (`nums[mid] > nums[high]`)**:
   - If the middle element is greater than the last element (`nums[mid] > nums[high]`), it means the left half is sorted.
   - Therefore, the minimum must be in the unsorted right half. We set `low = mid + 1`.

6. **Returning the result**:
   - Once the loop ends, `low` will point to the minimum element because we’ve narrowed the search space down to the minimum element.

- **Time Complexity**: O(N) in the worst case, where `N` is the length of the array. This occurs when there are many duplicates and we are forced to reduce the search space one element at a time. In the best case, if there are no duplicates, it would be O(log N).
  
- **Space Complexity**: O(1) as we are only using a few pointers (`low`, `high`, and `mid`).