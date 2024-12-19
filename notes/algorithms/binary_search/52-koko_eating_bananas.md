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
import java.util.*;

public class KokoEatingBananas {
    public static int findMax(int[] piles) {
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            maxi = Math.max(maxi, piles[i]);
        }
        return maxi;
    }

    public static int calculateTotalHours(int[] piles, int hourly) {
        int totalH = 0;
        for (int i = 0; i < piles.length; i++) {
            totalH += Math.ceil((double)(piles[i]) / (double)(hourly));
        }
        return totalH;
    }

    public static int minimumRateToEatBananas(int[] piles, int h) {
        int maxi = findMax(piles);
        for (int i = 1; i <= maxi; i++) {
            int reqTime = calculateTotalHours(piles, i);
            if (reqTime <= h) {
                return i;
            }
        }
        return maxi;  // return max pile size if no valid solution found
    }

    public static void main(String[] args) {
        int[] piles = {7, 15, 6, 3};
        int h = 8;
        int ans = minimumRateToEatBananas(piles, h);
        System.out.println("Koko should eat at least " + ans + " bananas/hr.");
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
        int low = 1, high = findMax(piles);
        int answer = high;  
        
        while (low <= high) {
            int mid = (low + high) / 2;
            int totalH = calculateTotalHours(piles, mid);
            
            if (totalH <= h) {
                answer = mid;  
                high = mid - 1;  
            } else {
                low = mid + 1;
            }
        }
        
        return answer; 
    }

    public int findMax(int[] v) {
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < v.length; i++) {
            maxi = Math.max(maxi, v[i]);
        }
        return maxi;
    }

    public int calculateTotalHours(int[] v, int hourly) {
        int totalH = 0;
        for (int i = 0; i < v.length; i++) {
            totalH += Math.ceil((double)(v[i]) / (double)(hourly));
        }
        return totalH;
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