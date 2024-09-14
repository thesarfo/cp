

You are given an array of `0`s and `1`s, and your task is to find the maximum number of consecutive `1`s in the array. For example, in the array `[1, 1, 0, 1, 1, 1, 0, 1, 1]`, the answer is `3` because the `1`s appear consecutively three times in a row, which is the maximum consecutive count.

[Leetcode 485](https://leetcode.com/problems/max-consecutive-ones/description/)

### Problem Explanation:
The problem is simple: given an array of binary digits (`0`s and `1`s), you need to find the longest sequence of consecutive `1`s. 

### Approach:
The solution is straightforward. We need two variables: 
- `count` - to keep track of the current sequence of consecutive `1`s.
- `max` (or `maxCount`) - to store the maximum number of consecutive `1`s encountered so far.

### Steps:
1. **Initialize the variables**:
   - `count = 0` to count the current sequence of consecutive `1`s.
   - `max = 0` to store the longest sequence found.

2. **Loop through the array**:
   - Each time we encounter a `1`, we increment the `count` variable to continue counting the sequence of consecutive `1`s.
   - If we encounter a `0`, it means the sequence is broken. At this point, we compare the current value of `count` with `max` and update `max` if `count` is greater. Then we reset `count` to `0` and continue the loop.
   
3. **Final Comparison**:
   - After the loop, it is important to do one final comparison between `count` and `max`. This ensures that if the array ends with a sequence of `1`s (like `[1, 1, 1, 0]` or `[1, 1]`), the final sequence is also considered.

### Key Points:
- **Updating `max`**: `max` is updated only when we encounter a `0` or after the loop ends.
- **Handling the last sequence**: If the array ends with a sequence of `1`s, that sequence might be the longest, so a final comparison is necessary to ensure we capture it.

### Example Walkthrough:
For an array `[1, 1, 0, 1, 1, 1, 0, 1, 1]`:
- **Step 1**: Initialize `count = 0` and `max = 0`.
- **Step 2**: Loop through the array:
  - The first two elements are `1`s, so `count = 2`.
  - We hit a `0`, so compare `count` (2) with `max` (0). Update `max = 2` and reset `count = 0`.
  - Continue, and the next sequence is `1, 1, 1`, so `count = 3`.
  - Another `0` is encountered. Compare `count` (3) with `max` (2), and update `max = 3`. Reset `count = 0`.
  - The last sequence is `1, 1`, so `count = 2`, but we don't encounter a `0` after this. Therefore, a final comparison ensures `max` remains 3.
  
### Code:

```cpp
class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int count = 0;
        int maxCount = 0; // stores maximum consecutive 1s
        
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == 1) {
                count++; // increment count for consecutive 1s
            } else {
                maxCount = std::max(maxCount, count); // update maxCount if count is greater
                count = 0; // reset count when a 0 is encountered
            }
        }

        // Final comparison for the case where the array ends with a sequence of 1s
        maxCount = std::max(maxCount, count);

        return maxCount;
    }
};
```

### Time Complexity:
- **O(n)**: We traverse the array only once, where `n` is the length of the array.

### Space Complexity:
- **O(1)**: We only use a few variables (`count`, `maxCount`), so the space complexity is constant.

