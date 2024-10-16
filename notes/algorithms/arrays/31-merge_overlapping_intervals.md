You are given an array of `n` subintervals - a subinterval of `(1, 3)` means it starts at `1` and ends at `3`. Your task is to merge all the overlapping subintervals into one, and find out how many minimum intervals you can return.

[Leetcode 56](https://leetcode.com/problems/merge-intervals/description/)

For instance, given the intervals `[(1, 3), (2, 6), (8, 9), (8, 10), (2, 4), (15, 18), (16, 17)]` - intervals `1, 3`, `2, 4` and `2, 6` can be merged as `1, 6`, intervals `8, 9`, `9, 11` and `8, 10` can be merged as `8, 11` and intervals `15, 18` and `16, 17` can be merged as `15, 18`.

Well, you might ask - why dont we simply merge everything as `1, 18`. Well that is because if you do it like that, you will end up having empty spaces. If you look at the merged intervals, above - take `1, 6` for instance, all the points between `1, 6` are being touched - `1, 2, 3, 4, 5, 6` are all being visited in that interval, this is why we cannot merge everything into one big interval.

So for the above example, the minimum number of subintervals they can be merged into is `3`.

1. **Brute Force Solution**: We can clap all the closer intervals together. First, we can sort all the intervals. And then we loop through the intervals, but how do we check if the next interval overalaps with the current interval - we check if the first element in the next interval is **lesser** than the last element in the previous interval.

How do we start a new interval, we know we need to start a new new one, when the first element in the next interval is **greater** then the last element of the previous interval.

Below is a code implementation.

```java
public int[][] merge(int[][] intervals) {

    // If there are no intervals, return an empty array
    if (intervals.length == 0) {
        return new int[0][];
    }

    // Sort the intervals based on the start times
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

    // Create a list to hold merged intervals
    List<int[]> result = new ArrayList<>();

    // Initialize with the first interval
    int start = intervals[0][0];
    int end = intervals[0][1];

    // Traverse the sorted intervals
    for (int i = 1; i < intervals.length; i++) {
        // If the current interval overlaps with the previous one, merge them
        if (intervals[i][0] <= end) {
            end = Math.max(end, intervals[i][1]);  // Extend the end time if overlapping
        } else {
            // If no overlap, add the previous interval and reset start and end
            result.add(new int[]{start, end});
            start = intervals[i][0];
            end = intervals[i][1];
        }
    }

    // Add the last interval
    result.add(new int[]{start, end});

    // Convert the list back to a 2D array
    return result.toArray(new int[result.size()][]);
}
```

The TC of the above algo is 0(n log n) for the sorting and 0(2n) for merging the intervals. And the SC is 0(n)

2. **Optimal Approach**: In the brute force solution, we currently stand at one interval and keep checking with the rest of the intervals to see if they can be merged. What if we could make that better with just a single iteration - first, we have nothing in our answer array(of intervals), so we can store the first interval in our input array into the answer interval, then we keep iterating through the input array, on each iteration, we check if the current interval can be merged with the interval in our answer array - it is mergeable only if the **first element in the current interval is less than the last element in the previous interval**, if it's mergeable, we update the answer array's interval's second value to the current input array's intervals second value. If it's not mergeable, we add the current interval in the input array, as its own interval in our answer array, then we keep iterating and checking.

Below is a sample code

```java
public int[][] merge(int[][] intervals) {
        // If there are no intervals, return an empty array
        if (intervals.length == 0) {
            return new int[0][];
        }

        // Sort the intervals based on the start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // This will store our merged intervals
        List<int[]> ans = new ArrayList<>();

        // Iterate over each interval
        for (int[] interval : intervals) {
            // If the list is empty or the current interval doesn't overlap with the previous one, add it
            if (ans.isEmpty() || interval[0] > ans.get(ans.size() - 1)[1]) {
                ans.add(interval);
            } else {
                // If it overlaps, merge the current interval with the previous one
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], interval[1]);
            }
        }

        // Convert the result list to an array
        return ans.toArray(new int[ans.size()][]);
    }
```

The TC of this is 0(n log n) + 0(n) for sorting and iteration and SC is 0(n).
