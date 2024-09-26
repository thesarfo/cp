## Problem Statement

You are given an array of integers, and your goal is to find the contiguous subarray that has the largest sum. The task is to return this maximum sum.

[Leetcode 54](https://leetcode.com/problems/maximum-subarray/)

---

### 1. **Brute Force Solution**

In the brute force approach, we can find the maximum subarray sum by checking all possible subarrays. This involves using three nested loops:

- The first loop runs from `0` to `n`, which represents the starting index of the subarray.
- The second loop runs from the starting index to `n-1`, representing the ending index of the subarray.
- The third loop calculates the sum of the elements in the subarray from index `i` to `j`.

Here's the Java implementation:

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int maxI = Integer.MIN_VALUE;  // Start with the lowest integer value

        // Iterate through all possible starting indices
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0; // Initialize sum for the current subarray
                for (int k = i; k <= j; k++) { // Calculate sum of subarray from i to j
                    sum += nums[k];
                }
                maxI = Math.max(maxI, sum); // Update maxI if current sum is greater
            }
        }
        return maxI;  // Return the maximum subarray sum found
    }
}
```

**Time Complexity**: **O(n³)** - This is inefficient for large arrays because of the three nested loops.

---

### 2. **Better Solution**

We can optimize the brute force solution by eliminating the third loop. Instead, we can calculate the sum of the subarray directly as we iterate through the second loop.

In this approach:

- We maintain a running sum as we expand the subarray from the starting index `i` to the ending index `j`.

Here's the optimized Java implementation:

```java
import java.lang.Math;

class Solution {
    public int maxSubArray(int[] nums) {
        int maxI = Integer.MIN_VALUE;  // Start with the lowest integer value

        // Iterate through all possible starting indices
        for (int i = 0; i < nums.length; i++) {
            int sum = 0; // Initialize sum for the new starting index
            // Calculate the sum of subarrays starting from index i
            for (int j = i; j < nums.length; j++) {
                sum += nums[j]; // Add the current element to sum
                maxI = Math.max(maxI, sum); // Update maxI if current sum is greater
            }
        }
        return maxI;  // Return the maximum subarray sum found
    }
}
```

**Time Complexity**: **O(n²)** - This is an improvement over the previous solution but can still be optimized further.

---

### 3. **Optimal Solution: Kadane's Algorithm**

Kadane's Algorithm provides an efficient way to find the maximum subarray sum with a time complexity of **O(n)**. 

**Approach**:
- Initialize two variables: `maxSoFar` (to store the maximum sum found) and `currentSum` (to store the sum of the current subarray).
- Start by setting `maxSoFar` to the first element of the array and `currentSum` to `0`.
- Iterate through the array:
  - Add each element to `currentSum`.
  - If `currentSum` exceeds `maxSoFar`, update `maxSoFar`.
  - If `currentSum` becomes negative, reset it to `0`, as starting a new subarray from the next element may yield a larger sum.

Here's the implementation of Kadane's Algorithm in Java:

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];  // Initialize to the first element
        int currentSum = 0;  // To track the current subarray sum
        
        // Iterate through the array
        for (int num : nums) {
            currentSum += num; // Add current number to currentSum
            maxSoFar = Math.max(maxSoFar, currentSum); // Update maxSoFar if needed
            
            if (currentSum < 0) { // Reset if currentSum is negative
                currentSum = 0;
            }
        }
        
        return maxSoFar;  // Return the maximum subarray sum found
    }
}
```

A more verbose solution would look like the below

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currentSum = 0;

        for(int i = 0; i < nums.length; i++){
            currentSum += nums[i];

            if (currentSum > maxSoFar) {
                maxSoFar = currentSum;
            }

            if(currentSum < 0){
                currentSum = 0;
            }
        }
        return maxSoFar;
    }
}
```

**Time Complexity**: **O(n)** - This is the most efficient solution for this problem, as we only need a single pass through the array.

**Space Complexity**: **O(1)** - We are using a constant amount of space regardless of the input size.

---

What if instead of the subarray's sum you were told to return the subarray itself. Below is an implementation

```java
import java.util.*;

class Solution {
    public static long[] maxSubarraySumWithIndices(int[] arr, int n) {
        long maxSum = arr[0];
        int currentSum = 0;
        int start = 0, end = 0, ansStart = 0, ansEnd = 0;

        for (int i = 0; i < n; i++) {
            if (currentSum == 0) {
                start = i; // mark potential start of new subarray
            }
            
            currentSum += arr[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
                ansStart = start;  // update the best subarray start index
                ansEnd = i;        // update the best subarray end index
            }

            if (currentSum < 0) {
                currentSum = 0;  // reset current sum if it's negative
            }
        }

        // Extract the subarray with the maximum sum
        long[] subarray = new long[ansEnd - ansStart + 1];
        for (int i = ansStart; i <= ansEnd; i++) {
            subarray[i - ansStart] = arr[i];
        }

        return subarray; // return the subarray with the maximum sum
    }
}
```