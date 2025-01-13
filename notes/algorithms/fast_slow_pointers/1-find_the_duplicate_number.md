Given an array of integers `nums` where `1 <= nums[i] <= n` (n is the size of the array), find the duplicate number in the array. There is **only one duplicate number** in the array, but it could be repeated multiple times.

You must solve it without modifying the array and using **O(1)** extra space.

[Leetcode Problem](https://leetcode.com/problems/find-the-duplicate-number/description/)

### Approach Overview:

This problem can be solved efficiently using **Floyd's Tortoise and Hare (Cycle Detection)** algorithm. This technique is based on the fact that the array can be interpreted as a linked list, and since one number is duplicated, it creates a cycle in this list.

### Key Insights:
- We are given that the array contains integers in the range `[1, n]`, so each number can be viewed as a pointer to another index in the array.
- Since there is only one duplicate, the array forms a cycle in terms of indices.

### Algorithm (Floyd’s Tortoise and Hare):

1. **Phase 1: Detecting the Cycle**
   - Initialize two pointers: `tortoise` (slow pointer) and `hare` (fast pointer).
   - Move the `tortoise` by one step and the `hare` by two steps.
   - If there's a cycle (which there will be due to the duplicate), the `tortoise` and `hare` will eventually meet.

2. **Phase 2: Finding the Entrance to the Cycle (the Duplicate)**
   - Once the `tortoise` and `hare` meet, reset one pointer to the beginning of the array and keep the other pointer where they met.
   - Move both pointers one step at a time. The point where they meet again is the start of the cycle, which is the duplicate number.

### Solution Code:

```java
class Solution {
    public int findDuplicate(int[] nums) {
        // Phase 1: Detect cycle using two pointers (Tortoise and Hare)
        int slow = nums[0];  // Tortoise
        int fast = nums[0];  // Hare

        // Move the pointers until they meet
        do {
            slow = nums[slow];        // Move slow by one step
            fast = nums[nums[fast]];  // Move fast by two steps
        } while (slow != fast);       // Keep going until they meet

        // Phase 2: Find the entrance to the cycle (duplicate)
        slow = nums[0];  // Reset slow to the beginning of the array
        while (slow != fast) {  // Move both pointers one step at a time
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;  // The duplicate number
    }
}
```

### Explanation:

1. **Cycle Detection (Phase 1)**:
   - The `tortoise` moves one step at a time (`slow = nums[slow]`).
   - The `hare` moves two steps at a time (`fast = nums[nums[fast]]`).
   - They will meet inside the cycle if a duplicate exists, since the duplicate causes the cycle.

2. **Finding the Duplicate (Phase 2)**:
   - Once the cycle is detected, we reset the `slow` pointer to the start of the array.
   - Now, both the `slow` and `fast` pointers move one step at a time (`slow = nums[slow]` and `fast = nums[fast]`).
   - The point where they meet again is the starting point of the cycle, which is the duplicate number.

### Time and Space Complexity:
- **Time Complexity**: `O(n)`, where `n` is the length of the array. The cycle detection process and the second phase of finding the duplicate both take linear time.
- **Space Complexity**: `O(1)`, since we are only using a constant amount of extra space for the two pointers (`slow` and `fast`).

### Why This Works:
- The cycle detection approach works because the duplicate number causes a "cycle" in the array. Treating the array as a linked list, we can use the Tortoise and Hare algorithm to detect the cycle and then find the entrance to the cycle, which corresponds to the duplicate number.

### Example:

For an input array like `nums = [1, 3, 4, 2, 2]`:
- The cycle starts at index `2`, and the number `2` is the duplicate.

### Edge Cases:
- The problem guarantees there is **one duplicate number**, so you don’t need to handle cases where no duplicate exists or multiple duplicates.
- The input array will always contain at least two elements (because `n >= 2`).

This approach is efficient and elegant for solving the problem in the required time and space complexity.