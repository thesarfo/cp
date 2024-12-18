You’re given an integer `n`, and your goal is to find its square root. If `n` isn’t a perfect square, you should return the **floor value** of the square root. 

**Floor value** simply means the greatest integer less than or equal to the square root.

[Practice Question 1](https://bit.ly/41AJb1p) <br>
[Practice Question 2](https://bit.ly/3JXtGcE)

### 1. **Brute Force Approach** (Linear Search)

The simplest way to solve this is to loop through all integers starting from `1` up to `n`. For each number, square it and check if it equals `n`. If squaring the number exceeds `n`, return the last valid number as the floor square root.

Here’s the implementation:

```java
int ans = 1;

for (int i = 1; i <= n; i++) {
    if (i * i <= n) {
        ans = i; // Update the answer while the square is valid
    } else {
        break; // Stop when the square exceeds n
    }
}
return ans;
```

- **Time Complexity**: `O(\sqrt{n})`, because we’re looping until the square root of `n`.
- **Space Complexity**: `O(1)`, as no extra space is used.

### 2. **Optimal Approach: Binary Search**

If you notice that the valid values form a pattern—valid until a certain point and invalid afterward—you can use **binary search** for a more efficient solution.

#### Idea:

1. Use two pointers, `low` and `high`, to define the search space.
2. Find the middle point, `mid`.
3. Check if `mid * mid` is:
   - Greater than `n`: Eliminate the right half by setting `high = mid - 1`.
   - Less than or equal to `n`: Update the answer to `mid` and search in the right half by setting `low = mid + 1`.
4. Continue until `low > high`.

Here’s the code:

```java
class Solution {
    int floorSqrt(int n) {
        int low = 1, high = n;
        int ans = 1; // Default to 1 for small values of n
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (mid * mid > n) {
                high = mid - 1; // Eliminate numbers greater than mid
            } else {
                ans = mid; // Update ans to mid as it's a valid candidate
                low = mid + 1; // Search for larger values
            }
        }
        return ans;
    }
}
```


### Key Points

- **Why Binary Search Works**:
  - Squaring a number increases monotonically, so once you find a number `x` such that `x^2 > n`, all numbers greater than `x` will also fail.
- **Edge Cases**:
  - `n = 0`: Square root is `0`.
  - `n = 1`: Square root is `1`.