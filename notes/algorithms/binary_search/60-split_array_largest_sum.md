You have been given an integer array and an integer `k`. Your task is to split the array into `k` non-empty subarrays such that the largest sum of any subarray is the minimum(minimized). Return the minimized largest sum of the split.

The goal is to split an array of integers into `k` subarrays such that the largest sum of any subarray is minimized. This means you want to distribute the numbers in a way that balances the sums of the subarrays, ensuring the maximum sum among them is as small as possible.

[Problem Link](https://leetcode.com/problems/split-array-largest-sum/description/)
[Problem Link 2](https://www.naukri.com/code360/problems/painter-s-partition-problem_1089557)

#### Problem Explanation

Imagine you have a list of numbers, and you want to split it into `k` groups (subarrays). Your goal is to make sure that the group with the largest sum has the smallest possible total. Here are the rules:

1. Every number in the list must belong to one and only one group.
2. Groups must consist of consecutive numbers from the list (subarrays).
3. The number of groups must be exactly `k`.

#### Example
Suppose the list is `[7, 2, 5, 10, 8]` and `k = 2`. There are several ways to split this list into two subarrays:
1. `[7, 2, 5]` and `[10, 8]` → Largest sum is `18` (sum of `[10, 8]`).
2. `[7, 2]` and `[5, 10, 8]` → Largest sum is `23` (sum of `[5, 10, 8]`).
3. `[7]` and `[2, 5, 10, 8]` → Largest sum is `25` (sum of `[2, 5, 10, 8]`).

Among these splits, the best way is `[7, 2, 5]` and `[10, 8]`, where the largest sum is minimized to `18`.


### Approach

To solve this problem, we use **binary search** combined with a **feasibility check**. Let’s walk through this process step by step.

#### Step 1: Define the Search Space

The key to solving this problem is realizing that the answer lies within a specific range:
1. The smallest possible value for the largest sum of any subarray is the largest single number in the array (`max(nums)`), because every subarray must contain at least one number.
2. The largest possible value for the largest sum of any subarray is the sum of all the numbers (`sum(nums)`), which happens when the entire array is treated as one subarray.

Thus, the range of potential answers is `[max(nums), sum(nums)]`.


#### Step 2: Use Binary Search to Narrow Down the Range

We perform binary search on this range to find the smallest value that satisfies the condition. Here’s the logic:
1. Calculate the middle value (`mid`) of the current range. This represents a candidate for the maximum sum of any subarray.
2. Check if it’s **feasible** to split the array into `k` subarrays such that the largest sum of any subarray is less than or equal to `mid`.

If it’s feasible:
- This means we can achieve the current `mid` as the largest sum. So, we try to find a smaller value by adjusting the range to `[low, mid - 1]`.

If it’s not feasible:
- This means `mid` is too small to allow a valid split. So, we increase the range to `[mid + 1, high]`.

We continue this process until the range is exhausted. The smallest feasible `mid` is our answer.


#### Step 3: Feasibility Check

To determine if a given `mid` value is feasible, we use a **greedy approach**:
1. Start with the first subarray and add numbers to it until adding another number would exceed `mid`.
2. When this happens, start a new subarray and continue adding numbers to it.
3. Count how many subarrays are created. If the count exceeds `k`, then `mid` is too small, and the split is not feasible.



Below is a code implementation
```java
public class Solution {
    public int splitArray(int[] nums, int k) {
        // Step 1: Define the search space
        int max = 0, sum = 0;
        for (int num : nums) {
            max = Math.max(max, num); // Find the maximum single element
            sum += num;              // Calculate the total sum
        }
        int low = max, high = sum;
        int result = 0;

        // Step 2: Binary search
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isFeasible(nums, k, mid)) {
                result = mid; // Update the result to the current feasible value
                high = mid - 1; // Try for a smaller maximum
            } else {
                low = mid + 1; // Try for a larger maximum
            }
        }

        return result;
    }

    // Helper method to check feasibility
    private boolean isFeasible(int[] nums, int k, int maxSum) {
        int subarrays = 1; // Start with one subarray
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum + num > maxSum) {
                subarrays++; // Start a new subarray
                currentSum = num; // Reset the sum for the new subarray

                if (subarrays > k) {
                    return false; // Too many subarrays needed
                }
            } else {
                currentSum += num; // Add to the current subarray
            }
        }

        return true; // Split is feasible
    }
}
```

---

### Example Walkthrough

Let’s walk through an example:

**Input**: `nums = [7, 2, 5, 10, 8]`, `k = 2`

1. **Search Space**:
   - `low = max(nums) = 10`
   - `high = sum(nums) = 32`

2. **Binary Search**:
   - **mid = 21**: Can we split the array into `k = 2` subarrays where the largest sum is ≤ 21?
     - Subarrays: `[7, 2, 5]` and `[10, 8]` → Valid (largest sum = 18).
     - Feasible → Update result to 21, try smaller values (`high = 20`).
   - **mid = 15**: Can we split the array into `k = 2` subarrays where the largest sum is ≤ 15?
     - Subarrays: `[7, 2, 5]` and `[10, 8]` → Not Valid (requires 3 subarrays).
     - Not feasible → Try larger values (`low = 16`).
   - **mid = 18**: Can we split the array into `k = 2` subarrays where the largest sum is ≤ 18?
     - Subarrays: `[7, 2, 5]` and `[10, 8]` → Valid (largest sum = 18).
     - Feasible → Update result to 18.

3. **Result**:
   - The minimized largest sum is `18`.


### Complexity Analysis

1. **Time Complexity**:
   - Binary search: Olog(sum-max)
   - Feasibility check: O(n) per iteration.
   - Total: O(nlog(sum -max))

2. **Space Complexity**:
   - O(1), as no additional data structures are used.