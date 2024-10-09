## Problem Statement
Given an array of integers, your task is to find the number of subarrays that sum up to a value `k`. For instance, given the array `[1, 2, 3, -3, 1, 1, 1, 4, 2, -3]` and `k = 3`, the number of subarrays that sum to `k` is `8`.

[Leetcode 560](https://leetcode.com/problems/subarray-sum-equals-k/)

## Solution Approaches

### 1. **Brute Force Approach**
In this method, we use three nested loops to generate all possible subarrays and check if their sum equals `k`.

#### Pseudocode:
```java
count = 0; // Initialize count of subarrays
for (i = 0; i < n; i++) { // Start index of subarray
    for (j = i; j < n; j++) { // End index of subarray
        sum = 0; // Reset sum for the new subarray
        for (k = i; k <= j; k++) { // Calculate the sum of the subarray arr[i..j]
            sum += arr[k];
        }
        if (sum == k) { // Check if the sum equals k
            count++; // Increment count if condition is met
        }
    }
}
```

#### Time Complexity:
- **O(n³)**: Due to three nested loops, making it inefficient for large arrays.

### 2. **Improved Solution**
In this approach, we eliminate the innermost loop by maintaining a running sum as we expand the subarray with the `j` pointer.

#### Pseudocode:
```java
count = 0; // Initialize count of subarrays
for (i = 0; i < n; i++) { // Start index of subarray
    sum = 0; // Initialize sum for the current starting index
    for (j = i; j < n; j++) { // Expand the end index of subarray
        sum += arr[j]; // Add the current element to the sum
        if (sum == k) { // Check if the sum equals k
            count++; // Increment count if condition is met
        }
    }
}
```

#### Time Complexity:
- **O(n²)**: Two nested loops. This is a significant improvement over the brute force method, with no extra space used, **O(1)**.

### 3. **Optimal Solution Using Prefix Sum and HashMap**
The optimal approach leverages the concept of prefix sums and a hashmap to count the number of valid subarrays in linear time.

#### Intuition:
- A prefix sum array is constructed to keep track of the sum of elements from the start of the array up to the current index.
- For each prefix sum, we check if there exists a previous prefix sum such that the difference between them equals `k`. This indicates that the subarray between those indices sums to `k`.

#### Pseudocode:
```java
count = 0; // Initialize count of subarrays
prefixSum = 0; // Initialize current prefix sum
map = new HashMap<Integer, Integer>(); // Map to store prefix sums and their counts
map.put(0, 1); // Initialize with the sum 0, which accounts for subarrays that sum directly to k

for (int num : arr) {
    prefixSum += num; // Update current prefix sum

    // Check if there exists a prefix sum that would satisfy the condition
    if (map.containsKey(prefixSum - k)) {
        count += map.get(prefixSum - k); // Increment count by the number of such prefix sums
    }

    // Update the map with the current prefix sum
    map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
}
```

#### Time Complexity:
- **O(n)**: One loop through the array, making this approach very efficient.
- **Space Complexity**: **O(n)** due to the hashmap storing prefix sums.

---