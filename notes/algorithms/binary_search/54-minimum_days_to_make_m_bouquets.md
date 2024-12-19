You are given `n` roses, and you are also given an array `arr` where `arr[i]` denotes the day that the `i`th rose will blooom. You can only pick already bloomed roses that are adjacent to make a bouquet. You are also told that you require exactly `k` adjacent bloomed roses to make a single bouquet. Find the number of days required to make at least `m` bouquets each containing `k` roses. Return `-1` if it is not possible.

[Leetcode Problem](https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/) <br>
[Practice Problem 2]()

Let's break down the problem using the example:

#### Given:
- **Array `arr`**: `{7, 7, 7, 7, 13, 11, 12, 7}`
  - Each number in this array represents the day when a particular rose blooms. For example:
    - The first rose blooms on day 7, the second rose blooms on day 7, and so on.
  
- **k**: The required number of adjacent roses to form one bouquet.
  - For example, if `k = 3`, we need 3 consecutive roses that have already bloomed to make a bouquet.

- **m**: The number of bouquets we need to create.
  - For example, if `m = 2`, we need 2 bouquets, each containing `k` adjacent bloomed roses.

- **Goal**: We need to figure out how many days it will take to form at least `m` bouquets, where each bouquet consists of exactly `k` **adjacent** bloomed roses. If it is not possible, return `-1`.




Let's consider the array:

```
arr = {7, 7, 7, 7, 13, 11, 12, 7}
```

- **Day 7**: The first four roses bloom on day 7.
- **Day 13**: The fifth rose blooms on day 13.
- **Day 11**: The sixth rose blooms on day 11.
- **Day 12**: The seventh rose blooms on day 12.
- **Day 7**: The eighth rose blooms on day 7.


### **The Problem Breakdown**

1. **Bouquet Requirements**:
   - We need `k = 3` adjacent bloomed roses for one bouquet.
   - We need to create **m = 2** bouquets.
   
2. **Steps**:
   - We are given a series of days when the roses bloom. To make bouquets, we need to find sequences of exactly `k` consecutive roses that have bloomed (in increasing order of days).
   
3. **What We Want to Find**:
   - The minimum day by which we can form **at least `m` bouquets** of `k` adjacent roses.
   - If it is not possible to form `m` bouquets, return `-1`.


### Observations

The observation here is that, if for instance - it is not possible to make `2` bouquets with `3` adjacent bloomed roses on the 11th day, then we know that it will also not be possible for all the days before the 11th day. 

So technically, we can say its not possible from days `1 to 11` but it is possible for days `12 and 13` - and the question says we need the minimum days possible. So in this case, our answer is `12`


Similarly, if we are given `[1, 10, 3, 10, 2]` with `m = 3` and `k = 2`, we know that all the flowers would have bloomed on the `10th` day, but can we make 3 bouquets with 2 adjacent flowers? This is not possible, because the array length itself is `5` < (m * k). So we cannot fulfill the requirements for this array.


### Impossible case

Just like the second observation above, we know that it is impossible to meet the requirements if `m * k` > `n`. Outside that, it is possible for all the other cases.

### Possible case and Intuition
What is the maximum answer? As in, can we pick a day which we are so sure that all the flowers would have bloomed and we can make `m` bouquets with `k` adjacent flowers? Yes, this would be the maximum day in the array - in other words, the maximum element in the array.

But we actually need the minimum, so how do we find the minimum day that meets these requirements. We can obviously start from day 1 all the way to the last day. But that wouldnt make sensse- since some flowers wouldnt even bloom if the day is less than the minimum day in our actual array. 

So, we can observe that at least the day we are looking for(our answer) will be between the minimum day and the maximumum day in our array

So we will pick our minimum day in the array, and then we will look for which flowers would have bloomed on that day, and try to see if we can make `m` bouquets with `k` adjacent flowers. So maybe you can keep a counter variable which tracks the number of bloomed flowers on that day - note that the counter will reset to `0` if we reach a day where the flower will not bloom. Then you check if you can make `m` flowers with the bloomed flowers inside of counter. This will be `counter / k` - and it will give us a value, which should idealy be equal to `m`. After we can keep the counter going.

After the minimum day, we simply check if the above approach is possible for the next day


# Brute Force Solution

1. **Write a helper function that takes the day number and tells you if it is possible or not**:

```java
boolean possible(int[] arr, int day, int m, int k) {
    int count = 0;  // Tracks consecutive bloomed roses
    int numOfBouquets = 0;  // Tracks the number of bouquets we can form

    // Iterate through each rose to see if it has bloomed by the current day
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] <= day) {  // Rose blooms by this day
            count++;  // Increase the counter for consecutive bloomed roses
        } else {
            // If we have enough consecutive bloomed roses, form a bouquet
            numOfBouquets += count / k;
            count = 0;  // Reset the counter when we hit a non-bloomed rose
        }
    }

    // After the loop, check for any remaining consecutive bloomed roses
    numOfBouquets += count / k;

    // Return true if we can form at least `m` bouquets
    return numOfBouquets >= m;
}

```

2. **Then we can simply check each individual day in our array to see if it is possible**
```java
public int minDays(int[] arr, int m, int k) {
    int n = arr.length;

    // Edge case: If there aren't enough roses to form `m` bouquets, return -1
    long val = (long) m * k;
    if (val > n) {
        return -1;
    }

    // Find the minimum and maximum days in the array
    int left = Integer.MAX_VALUE;
    int right = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
        left = Math.min(left, arr[i]);  // Find the earliest blooming day
        right = Math.max(right, arr[i]);  // Find the latest blooming day
    }

    // Check for each day from the earliest to the latest
    for (int day = left; day <= right; day++) {
        if (possible(arr, day, m, k)) {
            return day;  // Return the earliest day we can form `m` bouquets
        }
    }

    // If no solution is found, return -1
    return -1;
}
```

Can this be optimized? Yes it can. Since we know the range of days to check from(i.e min day and max day) - we could find the days which were not possible and the days which were possible. If its not possible for a particular day, then we know for sure that it absolutely cannot be possible for a day before that(eliminate the left part). This means we can apply the **Binary Search** algorithm here

# Optimal Solution

So, maintaining the same `possible` helper function, and the same way of finding our `mini` and `maxi` values, we can just apply standard binary search to look for our potential answer between `mini` and `maxi`

Below is the implementation

```java
boolean possible(int[] arr, int day, int m, int k) {
    int count = 0;  
    int numOfBouquets = 0;  

    for (int i = 0; i < arr.length; i++) {
        if (arr[i] <= day) {  
            count++;
        } else {
            numOfBouquets += count / k;
            count = 0; 
        }
    }

    numOfBouquets += count / k;

    return numOfBouquets >= m;
}


public int minDays(int[] arr, int m, int k) {
    int n = arr.length;

    // handle large edge cases
    long val = (long) m * k;
    if (val > n) {
        return -1;
    }
    int left = Integer.MAX_VALUE;
    int right = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
        left = Math.min(left, arr[i]);  
        right = Math.max(right, arr[i]);  
    }

    while(left <= right){
        int mid = (left + right) / 2;

        if(possible(arr, mid, m, k)){
            high = mid; // try to find an earlier possible day
        }else{
            low = mid + 1; // try a later day
        }
    }
    return low
}

```
