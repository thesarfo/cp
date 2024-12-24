- You are given `n` piles of bananas. The `i`-th pile has `a[i]` bananas.
- A time limit `h` is given (in hours), and Koko, the monkey, can eat `k` bananas per hour.
- Koko eats from one pile at a time, finishing it before moving to the next.
- If the number of bananas in a pile is less than `k`, Koko finishes the pile in that hour.

The goal is to find the **minimum number of bananas (`k`)** that Koko must eat per hour to finish all the piles in `h` hours or less. If it’s impossible, return -1.

[Practice Problem 1](https://leetcode.com/problems/koko-eating-bananas/) <br>
[Practice Problem 2](https://www.naukri.com/code360/problems/minimum-rate-to-eat-bananas_7449064?utm_source=striver&utm_medium=website&utm_campaign=codestudio_a_zcourse&leftPanelTabValue=SUBMISSION)

### Key Insight:
The minimum `k` that Koko can eat per hour lies between `1` (the lowest possible rate) and `max(a[])` (the pile with the most bananas). We want to find the smallest `k` such that Koko can finish the bananas in `h` hours.

### Approach:
1. **Brute Force (Naive) Approach:**
   - We check every possible value of `k` from `1` to `max(a[])`.
   - For each `k`, calculate the total time Koko would take to finish all the piles.
   - Return the first `k` where the total time is less than or equal to `h`.

2. **Optimal Approach (Binary Search):**
   - Use binary search to find the smallest `k`.
   - Since the answer space (from 1 to `max(a[])`) is sorted, binary search will efficiently find the answer by cutting the search space in half each time.

### Detailed Explanation:

#### Brute Force Approach:
1. **Find the maximum number of bananas** in any pile: `max(a[])`.
2. **Loop through all possible values of `k`** (from 1 to `max(a[])`):
   - For each `k`, calculate how many hours Koko will take for each pile. This is done by dividing the number of bananas in each pile by `k`, and rounding up (since Koko can’t eat fractions of bananas).
   - If the total time is less than or equal to `h`, then `k` is a valid answer.

Below is a code implementation - This gives us a TLE (Time Limit Exceeded)

```java
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Step 1: Find the maximum number of bananas in a single pile
        // This will determine the upper limit of Koko's eating speed
        int max = 0;
        for (int p : piles) {
            max = Math.max(max, p);
        }

        // Step 2: Perform a linear search to find the minimum eating speed
        // Start from 1 banana per hour and go up to the maximum pile size
        for (int k = 1; k < max; k++) {
            // Calculate the total hours Koko needs to eat all bananas at speed k
            int requiredTime = calculateTotalHours(piles, k);
            // If Koko can eat all bananas within h hours at speed k, return k
            if (requiredTime <= h) {
                return k;
            }
        }

        // If no speed from 1 to max - 1 satisfies the condition, return max
        // This is the worst-case scenario where Koko eats the largest pile in one hour
        return max;
    }

    // Helper method to calculate the total hours needed for Koko to eat all bananas
    // at a given hourly speed
    public int calculateTotalHours(int[] piles, int hourly) {
        int totalH = 0; // Total hours required
        for (int i = 0; i < piles.length; i++) {
            // Divide each pile size by the eating speed and round up to the nearest hour
            // Since Koko eats in whole hours, use Math.ceil
            totalH += Math.ceil((double) piles[i] / (double) hourly);
        }
        return totalH; // Return the total hours
    }
}
```

### Binary Search Approach:
1. **Binary Search Setup**:
   - Initialize `low = 1` and `high = max(a[])`.
2. **Mid Calculation**:
   - Compute `mid = (low + high) // 2`.
   - Calculate the total hours needed if Koko eats `mid` bananas per hour.
3. **Adjust Search Space**:
   - If the total hours `<= h`, then reduce the search space by adjusting `high = mid - 1` to find smaller valid values of `k`.
   - If the total hours `> h`, increase the search space by adjusting `low = mid + 1`.

4. **Return** the value of `low` as the answer once the search space is narrowed down.

#### Code Example (Binary Search Approach in Java):

```java
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Step 1: Find the maximum number of bananas in a single pile
        // This determines the upper limit for Koko's eating speed
        int max = 0;
        for (int p : piles) {
            max = Math.max(max, p);
        }

        // Step 2: Initialize the binary search bounds
        // 'low' is the minimum possible speed (1 banana per hour)
        // 'high' is the maximum possible speed (size of the largest pile)
        int low = 1, high = max;

        // Step 3: Binary search to find the minimum eating speed
        while (low < high) {
            // Calculate the midpoint (potential eating speed)
            int mid = low + (high - low) / 2;

            // Calculate the total hours required to eat all bananas at speed 'mid'
            int totalH = calculateTotalHours(piles, mid);

            // If the total hours are less than or equal to h, try a slower speed
            if (totalH <= h) {
                high = mid; // Reduce the upper bound to narrow the search
            } else {
                // Otherwise, try a faster speed
                low = mid + 1; // Increase the lower bound to narrow the search
            }
        }

        // Step 4: Return the minimum eating speed (low == high at this point)
        return low;
    }

    // Helper method to calculate the total hours needed for Koko to eat all bananas
    // at a given hourly speed
    public int calculateTotalHours(int[] piles, int hourly) {
        int totalH = 0; // Initialize total hours
        for (int i = 0; i < piles.length; i++) {
            // Divide each pile by the eating speed and round up to the nearest hour
            // Since Koko eats in whole hours, use Math.ceil
            totalH += Math.ceil((double) piles[i] / (double) hourly);
        }
        return totalH; // Return the total hours
    }
}
```

### Time and Space Complexity:
- **Brute Force Approach**:
  - **Time Complexity**: O(N * max(a[])), where `N` is the number of piles.
  - **Space Complexity**: O(1), constant space.

- **Binary Search Approach**:
  - **Time Complexity**: O(N * log(max((a[])), where `N` is the number of piles.
  - **Space Complexity**: O(1), constant space.

### Example Walkthrough:
#### Example 1:
Input: `a[] = {7, 15, 6, 3}, h = 8`
- Maximum bananas in a pile = 15.
- Using binary search, we find the smallest `k` (5 bananas per hour) that allows Koko to finish in 8 hours.
  
Output: `5` bananas/hr.

#### Example 2:
Input: `a[] = {25, 12, 8, 14, 19}, h = 5`
- Maximum bananas in a pile = 25.
- Koko can finish all piles in 5 hours if he eats 25 bananas per hour.
  
Output: `25` bananas/hr.