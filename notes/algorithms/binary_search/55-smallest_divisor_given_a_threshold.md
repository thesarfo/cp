You are given an array of integers, and a threshold number. Your task is to find the smallest positive integer divisor, such that upon dividing all the elements of the given array by it, the sum of the divisions result is less than or equal to the given threshold value.

[Leetcode 1283](https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/)

So basically, if you are given an array `[1, 2, 5, 9]` and a threshold of `6` - you will divide all the array elements by a divisor, taking the ceiling value of each division. Let's assume we pick a divisor of `4`

So `1/4 + 2/4 + 5/4 + 9/4` - which gives us `7`. But `7` is not less than or equal to our threshold (`6`). So, this divisor cannot be a possible answer. If we try a divisor `5`, it gives us `5` this is less than or equal to our threshold (`6`) - so this is a possible answer.

We continue to try other divisors, and then we find the smallest one that fits our condition.

1. **Brute Force Solution**: We can start by picking our divisor from `1` and try the division until we get a possible answer. If we get a possible answer, we stop(or store it somewhere) - if not we increment our divisor and continue. 

But until when do we stop our divisor? We know that at least our divisor should start from `1`(based on the question - and also division by zero is not possible). But what about it's maximum? If we pick a divisor `100` and do the division, we will get `4` after summing the result of those divisions. This is true for all elements that are greater than the largest element in the array. 

Therefore, we can conclude that the divisor we are looking for, lies between `1` and the *maximum element* in the array.

Below is a code implementation

```java
public int smallestDivisor(int[] nums, int threshold) {
        // Find the maximum value in the array
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // Start checking divisors from 1 to the maximum value in the array
        for (int d = 1; d <= max; d++) {
            int sum = 0;
            // Calculate the sum of Math.ceil(nums[i] / d) for all elements
            for (int num : nums) {
                sum += Math.ceil((double) num / d);
            }

            // If the sum is less than or equal to the threshold, return the divisor
            if (sum <= threshold) {
                return d;
            }
        }

        // If no divisor is found, return -1
        return -1;
    }
```

The TC of this is O(m * n), where `m` is the maximum element in the array - so we can optimize this further

2. **Optimal Solution - Binary Search**: Note that the input array is not sorted, however if you observe closely - you can realize that our answer space `1 - max(arr)` is actually sorted. Also there is a pattern that allows us to divide this space into two halves: one consisting of potential answers and the other consisting of non-viable options. Therefore, we can apply binary search on the answer space.

The pattern here is that

1. The smaller the divisor, we know that summing its divisions will actually be greater than our threshold. So at least we know that small numbers in our answer space may not be our answer

2. The larger the divisor, we know that summing its divisions will likely be less than or equal to our threshold. 


Based on the above pattern, if we pick a divisor in our answer space and do the sum of its divisions, and the result is greater than our threshold - we can eliminate that divisor and all the numbers that come before it.

However, if the sum of its divisions is less than or equal to our threshold, its a possible answer, we just need to check if perhaps there is an answer behind it that also fits our condition.


Below is a code implementation

```java
public int smallestDivisor(int[] nums, int threshold) {
        // Find the maximum number in nums, which will be the upper bound for the divisor
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // Initialize binary search bounds
        int low = 1, high = max;
        int answer = -1; // To store the result

        // Perform binary search on the divisor
        while (low <= high) {
            int mid = low + (high - low) / 2; 

            // Calculate the sum of divisors
            int sum = sumDivisors(nums, mid);

            // If the sum exceeds the threshold, we need a larger divisor
            if (sum > threshold) {
                low = mid + 1; // Increase the divisor to reduce the sum
            } else {
                answer = mid;  // We found a valid divisor, but there might be a smaller valid one
                high = mid - 1; // Try smaller divisors to find the minimum one
            }
        }

        return answer; // The smallest divisor that satisfies the threshold
    }

    public int sumDivisors(int[] nums, int divisor) {
        int sum = 0;

        for (int num : nums) {
            sum += Math.ceil((double) num / divisor); // Sum of the divisors
        }

        return sum; // Return the sum of divisors
    }
```

The TC of this is `O(NLog(Max))`