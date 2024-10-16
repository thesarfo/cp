### Problem Statement

Given an array of both positive and negative integers, compute the length of the largest subarray whose sum equals `0`.

**Example**:  
Input: `[15, -2, 2, -8, 1, 7, 10, 23]`  
Output: `5` (Subarray: `[-2, 2, -8, 1, 7]`)

[Problem Link](https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/)

---

### 1. Brute Force Solution

This approach involves generating all possible subarrays and checking their sums. If a subarray sums to `0`, we store its length. Finally, we return the length of the largest such subarray.

#### Steps:

- Generate all subarrays.
- Calculate the sum of each subarray.
- If the sum is `0`, track the length of the subarray.
- Return the length of the longest subarray with a sum of `0`.

**Time Complexity**: O(n³), where `n` is the size of the array (due to generating subarrays and calculating their sums).

While this works, it's inefficient for large arrays and can be optimized.

---

### 2. Optimized Solution - Hashing (Using Prefix Sum)

The key idea is to use a hashmap to store the prefix sums and their corresponding indices. We maintain a running sum as we iterate through the array and use the hashmap to track when the same sum reappears. If it does, it means the elements between those two indices sum to `0`.

#### Steps:

1. Initialize a hashmap to store the sum (as key) and the index (as value).
2. Start traversing the array while maintaining a running `sum`.
3. For each element:
   - Add the element to the running `sum`.
   - If the sum is `0`, it means the subarray from the start to the current index has a sum of `0`.
   - If the sum has been seen before (i.e., it's in the hashmap), it means the subarray between the previous occurrence of the sum and the current index has a sum of `0`. Update the maximum length accordingly.
   - If the sum hasn't been seen, store it in the hashmap with the current index.
4. Return the length of the largest subarray found.

**Time Complexity**: O(n), where `n` is the size of the array.  
**Space Complexity**: O(n), due to the hashmap storing prefix sums.

---

### Code Example (Java)

```java
import java.util.HashMap;

public class LargestSubarrayWithZeroSum {

    public static int maxLen(int[] arr) {
        // Map to store (prefix sum, index)
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int maxLength = 0;
        int sum = 0;

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If sum is 0, update maxLength (subarray from 0 to i)
            if (sum == 0) {
                maxLength = i + 1;
            }

            // If sum is seen before, it means there is a subarray with sum 0
            if (prefixSumMap.containsKey(sum)) {
                // Update maxLength if we found a longer subarray
                maxLength = Math.max(maxLength, i - prefixSumMap.get(sum));
            } else {
                // Store sum with its index
                prefixSumMap.put(sum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println("Length of the largest subarray with sum 0 is " + maxLen(arr));
    }
}
```

### Explanation:

- `sum`: Tracks the cumulative sum (prefix sum) as we iterate through the array.
- `prefixSumMap`: Stores each unique prefix sum and the index at which it first occurs.
- If we encounter the same prefix sum again, it means the subarray between the two indices has a sum of `0`.
- We update `maxLength` whenever we find a longer subarray with sum `0`.

---

### Key Intuition:

- If the cumulative sum (prefix sum) at two different indices is the same, then the elements between these indices must sum to `0`.
- The hashmap helps in efficiently checking and storing these prefix sums, reducing the time complexity from O(n³) to O(n).
