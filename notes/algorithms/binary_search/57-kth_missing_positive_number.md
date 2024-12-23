###  Problem Statement:

You are given a **strictly increasing array** `arr[]` and a **positive integer** `k`. Your task is to find the **kth positive integer missing** from the sequence of natural numbers that are not in the array `arr[]`.

### Example 1:

**Input:**  
`arr[] = {4, 7, 9, 10}`, `k = 1`'

**Output:**  
`1`

**Explanation:**  
The missing numbers are: `1, 2, 3, 5, 6, 8, 11, 12, ...`  
Since `k = 1`, the first missing number is `1`.

### Example 2:

**Input:**  
`arr[] = {4, 7, 9, 10}`, `k = 4`

**Output:**  
`5`

**Explanation:**  
The missing numbers are: `1, 2, 3, 5, 6, 8, 11, 12, ...`  
Since `k = 4`, the fourth missing number is `5`.

[Leetcode Problem](https://leetcode.com/problems/kth-missing-positive-number/description/)
[Code360 Problem](https://www.naukri.com/code360/problems/kth-missing-element_893215?utm_source=striver&utm_medium=website&utm_campaign=codestudio_a_zcourse)

### 1. **Brute Force Approach**

The observation of this approach is that we traverse the array while keeping track of every number that we come across. On each number we encounter, we increment `k` by 1. This increment reflects the fact that fewer numbers are missing up to that point than `k` initially represented. Essentially, every number in the array that is less than or equal to `k` "fills in" a gap in the sequence of missing numbers, pushing the missing count forward.

As we continue to traverse the array, we repeat this process for each number. If the current number in the array is still less than or equal to `k`, it means it has accounted for yet another missing number, so we increment `k` again. This adjustment ensures that `k` always represents the current position in the sequence of missing numbers as influenced by the numbers we’ve seen in the array.

Eventually, we reach a point where the number in the array becomes greater than `k`. At this moment, we know that `k` has not been shifted forward any further, meaning it still represents a missing number. Since the numbers in the array are strictly increasing, there are no earlier candidates that could account for this value of `k`. Therefore, the current value of `k` must be the `kth` missing number we are looking for. We stop the traversal at this point and return `k` as the answer.

This approach works seamlessly because the array is sorted in increasing order, which allows us to handle the missing numbers sequentially without ambiguity. By keeping `k` aligned with the missing sequence at each step, we ensure that the algorithm consistently identifies the correct result when the traversal stops.

**Approach**

* **Traverse the array** and check for missing numbers:
- For each number in the array, compare it to `k`.
- If the current number is less than or equal to `k`, increment `k` by 1.
- Once the current number is greater than `k`, stop and return `k` as the result.

#### Complexity Analysis:

- **Time Complexity:** O(N), where N is the size of the array, as we may have to loop through the entire array.
- **Space Complexity:** O(1), as no extra space is used except for a few variables.



### 2. **Optimal Approach (Using Binary Search)**

We can optimize the brute-force approach using **binary search** by narrowing the search space and efficiently pinpointing the range in which the `kth` missing number lies. Unlike standard binary search, where we search for a specific element in the array, here we are searching for the position of the `kth` missing number, which by definition does not exist in the array. The challenge is to determine the range in which this missing number would fall based on the gaps created by the numbers present in the array.

To illustrate this, consider the array `[2, 3, 4, 7, 11]` and `k = 5`. The goal is to find the `5th` missing number, which is **9**. At first glance, this might seem like a brute-force problem, but we can make the process more systematic by analyzing the number of missing elements at each position in the array.

In a perfect sequence with no missing numbers, the array would be `[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]`. However, in the given array, numbers are skipped. For example, the number `7` is present in the input array at index `3`, but ideally, it should have been `4` if all numbers were present. The discrepancy here is `7 - (3 + 1) = 3`, which tells us that **3 numbers are missing** from the sequence before `7`. Similarly, for `11`, the discrepancy becomes `11 - (4 + 1) = 6`, indicating that **6 numbers are missing** up to this point.

By applying this logic, we can determine the cumulative count of missing numbers at each position in the array. This allows us to observe that the `5th` missing number must lie between `7` and `11`. Up to the number `7`, only `3` numbers are missing, so the `5th` missing number has not yet been reached. Up to `11`, `6` numbers are missing, meaning the `5th` missing number must occur somewhere between these two elements.

With this observation, we can use binary search to pinpoint the exact position where the `5th` missing number lies. Instead of iterating through the array sequentially, we calculate the number of missing elements at the midpoint of our search space. If the number of missing elements at the midpoint is less than `k`, we know the `kth` missing number lies further to the right. Otherwise, we search to the left. This process continues until we have narrowed down the range to a single point, allowing us to compute the `kth` missing number efficiently.

**Steps**

1. **Initialize Binary Search**:  
    Start by setting `low = 0` and `high = n - 1`, where `n` is the size of the array.

2. **Calculate Missing Numbers**:  
    Use the formula `missing_numbers = arr[mid] - (mid + 1)` to determine how many numbers are missing up to index `mid`.
    
3. **Eliminate Halves**:
    
    - If `missing_numbers < k`, set `low = mid + 1` to search in the right half.
    - If `missing_numbers >= k`, set `high = mid - 1` to search in the left half.
4. **Identify Closest Index**:  
    Once the binary search ends, `high` will point to the largest index where the count of missing numbers is less than `k`.
    
5. **Calculate Remaining Missing Numbers**:  
    Compute how many more numbers are required to reach `k` using `more_missing_numbers = k - (arr[high] - (high + 1))`.
    
6. **Find the `kth` Missing Number**:  
    Determine the result with `kth_missing_number = arr[high] + more_missing_numbers`.
    
7. **Output the Result**:  
    Return `kth_missing_number` as the final answer.

#### Code Example (Java):

```java
public class KthMissingPositive {
    public static int missingK(int[] arr, int n, int k) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int missing = arr[mid] - (mid + 1);  // Calculate missing numbers up to mid
            if (missing < k) {
                low = mid + 1;  // Move to right half
            } else {
                high = mid - 1; // Move to left half
            }
        }
        return k + high + 1;  // Calculate the kth missing number
    }
}
```

#### Complexity Analysis:

- **Time Complexity:** O(log N), as we are using binary search on the indices.
- **Space Complexity:** O(1), since no extra space is used except for variables.