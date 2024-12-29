Given an array of integers representing the positions of stalls on a straight line, and a number representing the total cows, your task is to place the cows in the stalls such that the **smallest distance between any two cows is as large as possible**.

For example, if the stalls are positioned at `[0, 3, 4, 7, 10, 9]` and you need to place `4` cows, your goal is to determine the maximum possible value of this minimum distance.

You can arrange the cows in any manner within the stalls, but the challenge is to do so such that the **minimum distance between two cows is maximized**.

[Problem Link](https://bit.ly/42Vqzu9)

#### Observation:

To maximize the minimum distance between the cows, the cows should ideally be placed in **consecutive stalls** with enough spacing. Since the stall positions are not sorted, the first step is to **sort the array**, making it easier to place the cows systematically.

For example, after sorting, the stall positions become `[0, 3, 4, 7, 9, 10]`.

##### Approach:

1. Start by placing the first cow in the first stall.
2. Then, for each subsequent cow, place it in the **next stall** that maintains a required minimum distance from the last placed cow.
3. Repeat this process until all cows are placed.

Initially, the minimum distance may be small, but the question asks us to **maximize** it. To achieve this:

- Try different placement strategies that yield a larger minimum distance.
- Use techniques like binary search to efficiently test these placements and find the maximum possible minimum distance.

But we need to find the range within which our answer will lie, we can assume that the question will give us a minimum of 2 cows - therefore, the minimum distance we can get is `1` and the maximum will be `(max - min)`

### 1. Brute Force Approach: (Linear Search)

The problem asks us to place cows in stalls such that the minimum distance between any two cows is maximized. To do this, we can try **all possible values for the minimum distance**, starting from the smallest possible distance (`1`) and increasing it step by step. For each distance, we check if it’s feasible to place all the cows while maintaining that minimum distance.

#### How it Works:

1. **Sort the Stalls**: Sorting the stall positions ensures they are in order, which helps us easily calculate distances between stalls. For example, if the stalls are `[0, 3, 4, 7, 9, 10]`, the sorted positions are `[0, 3, 4, 7, 9, 10]`.

2. **Iterate Through Distances**: We start with the smallest possible minimum distance (`1`) and test if we can place all the cows while maintaining this distance. If yes, we try a larger distance. If no, we stop, and the largest distance that worked becomes our answer.

3. **Placing the Cows**:
    
    - Place the first cow in the first stall.
    - For each subsequent cow, place it in the next stall that is at least the required minimum distance away from the last placed cow.
    - If we manage to place all cows, the current distance is valid.
4. **Stop When Distance Fails**: If we cannot place all cows for a certain distance, it means larger distances will also fail. Therefore, we return the largest distance that worked.

Below is a code implementation

```java
    static int maximizeMinDistance(int[] stalls, int cows) {
        // Step 1: Sort the stalls
        Arrays.sort(stalls);

        // Step 2: Linear search for the maximum minimum distance
        for (int distance = 1; distance <= stalls[stalls.length - 1] - stalls[0]; distance++) {
            // Check if we can place all cows with this distance
            if (!canPlaceCows(stalls, cows, distance)) {
                // If we can't place, return the last valid distance
                return distance - 1;
            }
        }

        // If all distances work, return the maximum possible distance
        return stalls[stalls.length - 1] - stalls[0];
    }

    static boolean canPlaceCows(int[] stalls, int cows, int distance) {
        int count = 1; // number of cows
        int lastPosition = stalls[0]; // where you place the last cow

        // Try placing the rest of the cows
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= distance) {
                count++; // Place a cow
                lastPosition = stalls[i]; // Update last placed position
                if (count == cows) {
                    return true; // All cows placed successfully
                }
            }
        }

        // If we couldn't place all cows, return false
        return false;
    }
```

The TC of this is O(max * min) * O(n) where the space is O(1). We can optimize this further

### 2. Optimal Solution (Binary Search)

The binary search approach is more efficient than the brute force solution and leverages the fact that the problem has a clear **search space** where:

1. There is a range of possible minimum distances. (1, (max - min)).
2. For any distance `D`, if it's feasible to place all cows, then any smaller distance is also feasible. Conversely, if `D` is not feasible, any larger distance is also not feasible.

### Intuition Behind Binary Search:

- Instead of testing each possible minimum distance one by one (as in brute force), we can use **binary search** to narrow down the range of feasible distances.
- The idea is to test the middle distance (`mid`) in the current range. If placing all cows with this distance is possible, we move to larger distances. Otherwise, we move to smaller distances.
- This process efficiently narrows down the search space to find the largest valid minimum distance.
### Steps:

1. **Sort the Stalls**: Sorting ensures the stall positions are in increasing order, simplifying distance calculations.
    
2. **Set Up the Search Space**: The smallest possible distance is `1` (minimum gap between two cows). The largest possible distance is `max(stalls) - min(stalls)` (all cows at extreme ends).
    
3. **Binary Search**:
    
    - Calculate the middle distance (`mid`) of the current range.
    - Check if it’s feasible to place all cows with at least `mid` distance using a helper function.
    - If feasible, move to larger distances (`low = mid + 1`).
    - If not, move to smaller distances (`high = mid - 1`).
4. **Output**: The last valid distance tested is the largest possible minimum distance.

### Code Implementation:

```java
public class AggressiveCows {
    static int maximizeMinDistance(int[] stalls, int cows) {
        // Step 1: Sort the stalls
        Arrays.sort(stalls);

        // Step 2: Set up binary search range
        int low = 1; // Minimum possible distance
        int high = stalls[stalls.length - 1] - stalls[0]; // Maximum possible distance
        int result = 0; // To store the largest valid minimum distance

        // Step 3: Binary search
        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate middle distance

            // Check if we can place all cows with at least `mid` distance
            if (canPlaceCows(stalls, cows, mid)) {
                result = mid; // Update result to current valid distance
                low = mid + 1; // Try for a larger distance
            } else {
                high = mid - 1; // Try for a smaller distance
            }
        }

        return result; // Largest valid minimum distance
    }

    static boolean canPlaceCows(int[] stalls, int cows, int distance) {
        int count = 1; // Place the first cow in the first stall
        int lastPosition = stalls[0];

        // Try placing the rest of the cows
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= distance) {
                count++; // Place another cow
                lastPosition = stalls[i]; // Update last placed position
                if (count == cows) {
                    return true; // All cows placed successfully
                }
            }
        }

        return false; // Not all cows could be placed
    }
```

### Explanation of the Code:

1. **Sorting**:
    
    - Stalls are sorted to make distance calculations straightforward.
2. **Binary Search**:
    
    - The `low` and `high` variables define the search space for the minimum distance.
    - The middle distance (`mid`) is tested for feasibility.
3. **Placement Check (`canPlaceCows`)**:
    
    - Cows are placed greedily: the first cow is placed in the first stall, and subsequent cows are placed in the next stall that is at least `distance` away from the last placed cow.
4. **Result**:
    
    - If a distance is valid (`canPlaceCows` returns `true`), it updates `result` and moves to larger distances.
    - Otherwise, it moves to smaller distances.

The TC of the sorting is O(n log n) whereas the TC of the binary search is O(log(maxDistance)) where as the TC of the placement  check is O(n). Therefore, the total TC is (O n log n + n log(maxDistance)) whereas that of the SC is O(1)
