
You are given two numbers, `n` and `m`. Your task is to find the n-th root of `m`. If the  n-th root isn’t an integer, return `-1`.

Example:
Input: `n` = 3, `m` = 27

Output: `3`

Explanation: 
3rd Root of 27 is 3, as `3^3` equals 27.

[Practice 1](https://bit.ly/3zWNyrL) <br>
[Practie 2](https://bit.ly/42StZ0I)


### 1. **Brute Force Approach** (Linear Search)

We can loop through numbers starting from `1` up to `m`. For each number, compute `i^n` (the number raised to the power `n` and check:

- If `i^n = m`, return `i`.
- If `i^n > m`, stop the loop and return `-1`.

This approach works well for small values of `m`.

#### Code:
```java
public int nthRoot(int n, int m) {
    for (int i = 1; i <= m; i++) {
        double power = Math.pow(i, n); // Calculate i^n
        
        if (power == m) {
            return i; // Found the nth root
        } else if (power > m) {
            break; // No valid root exists
        }
    }
    return -1; // No integer root found
}
```

#### Complexity:
- **Time**: `O(m)` — Loops through all numbers up to `m`.
- **Space**: `O(1)`.


### 2. **Optimal Approach** (Binary Search)

If you want a faster solution, binary search is ideal. Instead of looping from `1` to `m`, we use a search range:

1. Set `low = 1` and `high = m`.
2. Find the middle point `mid` in each iteration.
3. Compute `mid^n`:
   - If `mid^n = m`, return `mid`.
   - If `mid^n > m`, reduce the range by setting `high = mid - 1`.
   - If `mid^n < m`, increase the range by setting `low = mid + 1`.
4. If no integer `n-th` root is found, return `-1`.

#### Code:
```java
public int nthRoot(int n, int m) {
    int low = 1, high = m;
    
    while (low <= high) {
        int mid = (low + high) / 2;
        double power = Math.pow(mid, n); // Calculate mid^n
        
        if (power == m) {
            return mid; // Found the nth root
        } else if (power > m) {
            high = mid - 1; // Eliminate larger values
        } else {
            low = mid + 1; // Eliminate smaller values
        }
    }
    return -1; // No integer root found
}
```

#### Complexity:
- **Time**: `O(log m)` — Binary search reduces the search range in each iteration.
- **Space**: `O(1).



### Key Points:
- Use **brute force** for small values of `m`.
- Use **binary search** for larger values of `m` to improve efficiency.
- Edge Cases:
  - `n = 1`: Always return `m`, as `m^1 = m`.
  - If `m = 0` or `m = 1` , handle these early since they’re trivial cases.