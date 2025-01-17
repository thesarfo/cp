We are tasked with finding the `k`th positive integer missing from a strictly increasing array of positive integers.

### Observations:
1. If the array were continuous, there would be no missing numbers, i.e., `[1, 2, 3, ...]`.
2. The difference between the expected number (`index + 1`) and the actual number in `arr[index]` tells us how many numbers are missing up to that index.

For example, if `arr = [2, 3, 4, 7, 11]`:
- Index `0`: Expected is `1`, actual is `2`, so `missing = 1`.
- Index `1`: Expected is `2`, actual is `3`, so `missing = 1`.
- Index `2`: Expected is `3`, actual is `4`, so `missing = 1`.
- Index `3`: Expected is `4`, actual is `7`, so `missing = 3`.

If the total missing numbers up to an index exceeds `k`, we know the `k`th missing number is in that gap.

---

### Approaches:

#### 1. **Linear Search (O(n))**:
We iterate over the array, counting the number of missing integers until the count reaches `k`. If the end of the array is reached without finding the `k`th missing number, we calculate it directly based on the count so far.

```java
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int missingCount = 0, lastMissing = 0;
        int index = 0;

        // Iterate through numbers starting from 1
        for (int i = 1; missingCount < k; i++) {
            if (index < arr.length && arr[index] == i) {
                // Current number exists in the array
                index++;
            } else {
                // Current number is missing
                missingCount++;
                lastMissing = i;
            }
        }

        return lastMissing;
    }
}
```

#### **Time Complexity**:
- \( O(n + k) \), where \( n \) is the array length and \( k \) is the position of the missing integer.

---

#### 2. **Binary Search (O(\log n))**:
Instead of iterating, we use **binary search** to narrow down where the `k`th missing integer is.

1. For any index `i`, the total number of missing integers up to `arr[i]` is `arr[i] - (i + 1)`.
2. If `arr[i] - (i + 1) < k`, the `k`th missing number is in the right part of the array.
3. If `arr[i] - (i + 1) >= k`, the `k`th missing number is in the left part.

**Steps**:
1. Use binary search to find the smallest index `i` such that `arr[i] - (i + 1) >= k`.
2. Compute the result as `k + i` because every index shift implies missing numbers.

---

#### Binary Search Implementation:

```java
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 0, high = arr.length - 1;

        // Binary search for the smallest index where missing >= k
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                low = mid + 1; // Missing count is too small, go right
            } else {
                high = mid - 1; // Missing count is too large, go left
            }
        }

        // After binary search, 'low' points to the smallest index with missing >= k
        return low + k;
    }
}
```

---

#### **Time Complexity**:
- \( O(\log n) \), as we perform binary search on the array.

#### **Space Complexity**:
- \( O(1) \), as no additional space is used.

---

### Examples:

#### Example 1:
```java
Input: arr = [2,3,4,7,11], k = 5
Output: 9
```

- Total missing at the end is \( 11 - (5) = 6 \), which includes `9`.

#### Example 2:
```java
Input: arr = [1,2,3,4], k = 2
Output: 6
```

- No missing numbers in the array, so we calculate directly from \( k \).

---

### Key Notes:
1. **Binary Search Advantage**: More efficient for larger arrays, reducing iterations.
2. **Linear Search Simplicity**: Easier to implement, but slower for edge cases where \( k \) is large or the array is long.