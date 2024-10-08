### **Problem Statement:**
You have an array of integers, where each integer represents the maximum number of steps you can jump forward from that position. The goal is to determine if you can reach the last index starting from the first index.


[Leetcode 55](https://leetcode.com/problems/jump-game/description/)


### **Example:**
- Given the array `[2, 3, 1, 1, 4]`:
  - From index `0`, you can jump up to `2` steps.
  - From index `1`, you can jump up to `3` steps.
  - And so on...

### **Key Idea:**
Instead of trying to jump to each index, we will keep track of the **farthest point** we can reach at any time. This allows us to quickly determine if we can get to the end of the array without checking every single possible jump.

### **Steps to Solve:**

1. **Initialize `maxReach`:**
   - Start with a variable called `maxReach`, which represents the farthest index you can currently reach. We initialize it to `0` because we start at the first index.

2. **Iterate Through the Array:**
   - Loop through each index `i` in the array:
     - **Check if `i` is reachable:** 
       - If `i` is greater than `maxReach`, it means we cannot reach this index. In this case, we return `false`.
     - **Update `maxReach`:** 
       - Calculate the farthest point we can reach from index `i` using the formula `i + nums[i]`. Update `maxReach` to be the maximum of its current value and this new value.
     - **Check if we can reach the last index:** 
       - If `maxReach` is greater than or equal to the last index (`nums.length - 1`), return `true` because we can reach the end.

3. **Final Check:**
   - If we finish the loop and never reach the last index, return `false`.

### **Example Walkthrough:**
Let’s walk through the example array `[2, 3, 1, 1, 4]`:

- **At index `0`:**
  - `maxReach = 0`
  - Jump value: `2` → You can reach up to index `2` (`0 + 2`).
  - Update `maxReach` to `2`.

- **At index `1`:**
  - `i = 1`, `maxReach = 2`
  - Jump value: `3` → You can reach up to index `4` (`1 + 3`).
  - Update `maxReach` to `4`.

- **At index `2`:**
  - `i = 2`, `maxReach = 4`
  - Jump value: `1` → You can reach up to index `3` (`2 + 1`).
  - `maxReach` remains `4` (since `4` is greater than `3`).

- **At index `3`:**
  - `i = 3`, `maxReach = 4`
  - Jump value: `1` → You can reach up to index `4` (`3 + 1`).
  - `maxReach` remains `4`.

- **At index `4`:**
  - `i = 4`, `maxReach = 4`
  - You are at the last index, so you return `true`.

### **Java Code Snippet:**

Here's the Java implementation of the solution:

```java
class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0; // Farthest point we can reach
        
        for (int i = 0; i < nums.length; i++) {
            // If current index is greater than maxReach, we can't reach this index
            if (i > maxReach) {
                return false; 
            }
            // Update the farthest point we can reach
            maxReach = Math.max(maxReach, i + nums[i]);
            
            // If we can reach or exceed the last index, return true
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        
        return false; // If we finish the loop and can't reach the last index
    }
}
```

### **Conclusion:**
The solution uses a smart way to keep track of how far you can jump instead of checking every possible jump. This makes it efficient and quick. If you can ever reach or exceed the last index, you can successfully reach the end of the array!

