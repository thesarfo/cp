You have `1` ship, and you have `n` products, each of these products' weight have been represented by a `weights` array where `weight[i]` is the weight of the `i`th product. Each day, you load the ship with the packages in the order given by `weights`. You must not load more weight than the maximum weight capacity of the ship.

Your task is to find the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within `days` days.

- [Leetcode Problem](https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/)
- [Code360 Problem](https://www.naukri.com/code360/problems/capacity-to-ship-packages-within-d-days_1229379?utm_source=striver&utm_medium=website&utm_campaign=codestudio_a_zcourse)


**Example**
Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5

Output: 15

Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
- 1st day: 1, 2, 3, 4, 5 = 15
- 2nd day: 6, 7 = 13
- 3rd day: 8 = 8
- 4th day: 9 = 9
- 5th day: 10 = 10

Note how on each day, the products shipped didn't exceed the ship's maximum capacity. An answer of `15` means that this is the lowest ship capacity that can get this job done


### Intuition
First, we need to find our capacity, then we will worry about finding the least one. One thing we know for sure is that if we pick a capacity less than the maximum weight of our products, that capacity will not get the job done. Using the example above, imagine we pick a capacity of `8` - we will not be able to ship products `9` and `10`.

- Therefore, we can conclude that the capacity we need should at least be greater than or equal to the maximum weight of our products.

Now, we have a starting point, but where does this capacity end. If we think about it, summing up all the weights of the products we have(`55`) will get the job done in just `1` day. 

- Therefore, we can conclude that the maximum capacity we can reach is the summation of all the weights of our products.

In the above example, this means our capacity range is between `10` and `55`


Here’s a more polished explanation of your Brute Force Solution with a couple of fixes for clarity and optimization:

### 1. Brute Force Solution (Linear Runtime):
In this approach, we can loop through the `weights` array, and for each possible ship capacity, we calculate how many days are required to ship all the packages. If the number of days required is less than or equal to the given number of days (`days`), we return the current capacity.

**Approach**:
- First, find the maximum weight and total sum of weights from the `weights` array.
- Then, for each potential capacity (starting from the maximum weight and increasing until the total sum), calculate how many days would be required to ship all the packages using that capacity.
- If the number of days required is less than or equal to the given `days`, return the current capacity.

Below is a code implementation:

```java
public int shipWithinDays(int[] weights, int days) {
    int max = 0, sum = 0;
    for (int weight : weights) {
        sum += weight;
        max = Math.max(max, weight);
    }
    
    // Start checking from the max weight up to the total sum of weights
    for (int capacity = max; capacity <= sum; capacity++) {
        int daysReq = findDays(weights, capacity);
        if (daysReq <= days) {
            return capacity;
        }
    }
    return -1;  // In case no valid capacity is found (although it should not happen)
}

public int findDays(int[] weights, int capacity) {
    int days = 1, load = 0;  // Start with one day
    for (int i = 0; i < weights.length; i++) {
        if (load + weights[i] > capacity) {
            days++;  // Increment day count if current load exceeds capacity
            load = weights[i];  // Start a new day with the current weight
        } else {
            load += weights[i];  // Add weight to the current day's load
        }
    }
    return days;
}
```

This brute-force solution checks all possible ship capacities starting from the maximum weight and increasing until the total sum of weights. It calculates how many days it would take to ship the packages for each capacity and returns the first capacity that works within the allowed number of days.

The TC of this is O(sum-max) * O(n). However, the above code may give us a TLE. We can optimize it further.


### 2. Optimal Solution (Binary Search):
We know the range is between the maximum weight and the sum of all the weights. This is because the ship's capacity must be at least the maximum weight (to fit the heaviest package) and at most the total sum of all weights (to ship everything in one day).

To efficiently find the least capacity that allows us to ship all packages within thhe given number of days, we can use *binary search*. The idea is to look for the smallest capacity in the range[max, sum] such that shipping within the specified number of days is possible.

**Approach**
1. **Binary Search Setup**: Start with a range where the low boundary is the maximum weight (`max`) and the high boundary is the total sum of weights (`sum`).

2. **Midpoint Calculation**: In each iteration of the binary search, calculate the midpoint capacity between the current low and high boundaries.

3. **Check Feasibility**: For the current midpoint capacity, use the `findDays` function to determine how many days it would take to ship all packages with this capacity. If the number of days is within the given limit (`days`), the capacity is valid, so we try smaller capacities by adjusting the high boundary. If it's too large, adjust the low boundary to try larger capacities.

4. **Termination**: The binary search ends when the low and high boundaries converge to the minimum valid capacity.

Below is a code implementation

```java
public int shipWithinDays(int[] weights, int days) {
    int max = 0, sum = 0;
    
    // Calculate the maximum weight and the total sum of all weights
    for (int weight : weights) {
        sum += weight;
        max = Math.max(max, weight);
    }
    
    // Apply binary search between the max weight and the total sum
    int left = max, right = sum;
    int answer = right;  // Initialize answer to the max possible value (right)
    while (left <= right) {
        int mid = left + (right - left) / 2;  // Midpoint capacity
        
        // Check how many days are needed with this capacity
        int daysReq = findDays(weights, mid);
        
        // If the required days is within the allowed limit, try smaller capacity
        if (daysReq <= days) {
            answer = mid;  // Update answer to the current valid capacity
            right = mid - 1;  // Try smaller capacity
        } else {
            left = mid + 1;  // Try larger capacity
        }
    }
    
    return left;  // The smallest valid capacity
}

public int findDays(int[] weights, int capacity) {
    int days = 1, load = 0;  // Start with one day
    for (int i = 0; i < weights.length; i++) {
        if (load + weights[i] > capacity) {
            days++;  // Increment day count if current load exceeds capacity
            load = weights[i];  // Start a new day with the current weight
        } else {
            load += weights[i];  // Add weight to the current day's load
        }
    }
    return days;
}
```

The binary search checks the middle capacity (`mid`) between the minimum possible capacity (`max`) and the maximum possible capacity (`sum`). For each `mid`, it calculates the number of days required to ship all the packages. If the days required is less than or equal to the given days, we try smaller capacities by adjusting the `right` boundary; otherwise, we try larger capacities by adjusting the `left` boundary.

The TC of the binary search is `O(log(sum - max))` whereas that of the `findDays` function is O(n). So the total TC is `O(n * log(sum - max))`