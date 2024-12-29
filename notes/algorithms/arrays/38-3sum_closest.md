
Given an integer array `nums` of length `n` and a target integer `target`, find three integers in `nums` such that the sum is closest to `target`. Return the sum of the three integers.

[Problem link](https://leetcode.com/problems/3sum-closest)

### Key Points
- The goal is to **minimize the difference** between the sum of three numbers and the target.
- The closest sum could be smaller or larger than the target, so we use absolute difference (`Math.abs`).


## Intuition

1. **Finding Closest Sum:**
   - To find a sum close to the target, we compare the difference between the current sum and the target.
   - We use absolute difference because we only care about how far the sum is from the target, not the direction (whether it's above or below).

2. **How to Search Efficiently:**
   - A brute force solution tests all combinations of three numbers, but this is inefficient (\(O(n^3)\)).
   - Sorting the array and using two pointers reduces the search space and helps make the solution faster (\(O(n^2)\)).


### 1: Brute Force

### Algorithm
1. Iterate over all possible triplets in the array using three nested loops.
2. For each triplet:
   - Calculate the sum.
   - Compare the absolute difference between the sum and the target with the current closest sum.
   - Update the closest sum if the current sum is closer.

Below is a code implementation
```java
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closestSum = Integer.MAX_VALUE / 2;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];

                    if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                        closestSum = sum;
                    }
                }
            }
        }

        return closestSum;
    }
}
```

### Complexity
- **Time Complexity**: \(O(n^3)\) (Three nested loops)
- **Space Complexity**: \(O(1)\)


### 2: Optimal Solution (Two Pointers)

### Key Insights
1. **Sorting the Array:**
   - Sorting allows us to systematically explore combinations of numbers using pointers.
   - This is critical for efficiently finding sums close to the target.

2. **Two Pointers:**
   - After fixing one element, use two pointers (`left` and `right`) to explore possible combinations:
     - If the sum is less than the target, move `left` to increase the sum.
     - If the sum is greater than the target, move `right` to decrease the sum.
   - This approach ensures that every combination is considered in a systematic way.

3. **Stopping Condition:**
   - If the exact target sum is found, stop and return it, because no closer sum exists.


### Algorithm
1. Sort the array.
2. Iterate through the array, fixing one element at a time.
3. Use two pointers to find the closest sum for the remaining two elements:
   - Move the pointers inward based on whether the current sum is less than or greater than the target.
4. Keep track of the closest sum encountered during the process.

### Code (Optimal)
```java
import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Sort the array
        Arrays.sort(nums);
        int closestSum = Integer.MAX_VALUE / 2;

        // Iterate through the array
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1; // Start of the remaining array
            int right = nums.length - 1; // End of the array

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // Update the closest sum
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                // Move the pointers
                if (sum < target) {
                    left++; // Increase the sum
                } else if (sum > target) {
                    right--; // Decrease the sum
                } else {
                    // Exact match found
                    return sum;
                }
            }
        }

        return closestSum;
    }
}
```

### Complexity
- **Time Complexity**: \(O(n^2)\)
  - Sorting: \(O(n \log n)\)
  - Two-pointer search for each fixed element: \(O(n^2)\)
- **Space Complexity**: \(O(1)\)

