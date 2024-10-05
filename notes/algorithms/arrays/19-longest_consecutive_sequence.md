### Problem:
You are given an array of integers, and your task is to find the longest consecutive sequence of numbers in that array. For example, given the array `[102, 4, 100, 1, 101, 3, 2, 1, 1]`, the longest consecutive sequence is `[1, 2, 3, 4]`, which has a length of `4`. Another sequence, `[100, 101, 102]`, has a length of `3`, but it is not the longest.

[Leetcode 128](https://leetcode.com/problems/longest-consecutive-sequence/description/)

### Approach 1: Brute Force

One naive approach would be to take each element `x` in the array and try to build a sequence by checking if `x+1`, `x+2`, and so on are present in the array. We could initialize a variable to store the longest sequence found so far, then iterate through the array to check if each element has a `+1` in the array. If it does, we increment our count of the current sequence length; otherwise, we move to the next element.

#### Code Example:

```java
longest = 1;

for(int i = 0; i < n; i++){
    int x = arr[i];
    int count = 1;

    while(linear_search(arr, x + 1) == true){
        x = x + 1;
        count = count + 1;
    }

    // Update the longest sequence length found
    longest = Math.max(longest, count);
}
```

#### Time Complexity:
The time complexity of this brute force approach is `O(n^2)` because for every element in the array, we are searching for the next consecutive element. This is inefficient for larger inputs, so we need a better solution.

---

### Approach 2: Better Solution

A more efficient solution involves sorting the array first. Once sorted, consecutive elements should appear next to each other, making it easier to identify sequences.

**Idea**:  
- We initialize a variable to track the length of the current consecutive sequence.
- If an element `arr[i]` is part of a consecutive sequence, the element just before it should be `arr[i] - 1`, and the one after it should be `arr[i] + 1`. 
- We also maintain another variable to store the longest sequence found so far.
- If two consecutive elements are not part of a sequence (i.e., they differ by more than `1`), we reset the count for the current sequence and start over from the new element.

#### Refined Intuition:
- First, we sort the array.
- For each element in the array, we check if it can extend the current sequence (i.e., if it’s `arr[i] - 1`). If so, we increase the count of the current sequence. 
- If the current element equals the previous element (`arr[i] == arr[i-1]`), we skip it to avoid counting duplicates.
- If the element breaks the sequence, we reset the count and continue.

#### Code Example:

```java
Arrays.sort(arr);  // Sort the array

int longest = 1, count_curr = 1, last_smaller = arr[0];  // Initialize variables

for(int i = 1; i < arr.length; i++){
    if(arr[i] - 1 == last_smaller){  // If it's a consecutive number
        count_curr++;  // Increment current sequence count
        last_smaller = arr[i];  // Update the last smaller number
    }
    else if(arr[i] == last_smaller){  // Skip duplicates
        continue;
    }
    else{
        count_curr = 1;  // Reset current count
        last_smaller = arr[i];  // Update last smaller number
    }

    longest = Math.max(longest, count_curr);  // Update the longest sequence length found
}
```

### Why This Works Better:
- **Time Complexity**: Sorting the array takes `O(n log n)`, and then we traverse it once (`O(n)`), making the overall time complexity `O(n log n)`. This is a significant improvement over the brute force approach.
- **Space Complexity**: We only need a few extra variables, so the space complexity remains `O(1)`.

By sorting the array first, we avoid repeatedly searching for the next element in the sequence, leading to a more efficient algorithm.

--- 

Here’s how you can continue and improve the **Optimal Solution** approach for finding the longest consecutive sequence:

---

### Approach 3: Optimal Solution

To further improve efficiency, we can use a **HashSet**. The key idea is to avoid sorting altogether and instead rely on the `O(1)` average time complexity of searching in a set. We can first insert all elements into a set, which will allow us to quickly check if the current element starts a new sequence or not.

**Key Intuition**:
- If an element `x` is the start of a sequence, `x - 1` should not be present in the set. This is because if `x - 1` exists, then `x` is part of a longer sequence that started with `x - 1`. 
- Once we identify that `x` is the start of a sequence, we can count how many consecutive numbers follow `x` by checking for `x + 1`, `x + 2`, and so on.

#### Steps:
1. Insert all elements into a set to allow constant-time lookup.
2. Iterate through the array:
    - For each element `x`, check if `x - 1` exists in the set.
    - If `x - 1` does **not** exist, then `x` is the start of a new sequence.
    - From there, count how many consecutive numbers exist by checking for `x + 1`, `x + 2`, and so on.
    - Update the longest sequence length as necessary.

#### Code Implementation:

```java
public int longestConsecutive(int[] nums) {
    if (nums.length == 0) return 0;  // Handle edge case

    Set<Integer> numSet = new HashSet<>();
    for (int num : nums) {
        numSet.add(num);  // Add all elements to the set
    }

    int longest = 0;

    for (int num : numSet) {
        // Check if this is the start of a sequence
        if (!numSet.contains(num - 1)) {
            int currentNum = num;
            int currentStreak = 1;

            // Count the streak of consecutive numbers
            while (numSet.contains(currentNum + 1)) {
                currentNum++;
                currentStreak++;
            }

            // Update the longest streak
            longest = Math.max(longest, currentStreak);
        }
    }

    return longest;
}
```

### Why This Works:
- **Efficiency**: By using a set, we reduce the time complexity for checking consecutive elements from `O(n^2)` (in the brute force approach) to `O(1)` per lookup.
- **Time Complexity**: The overall time complexity is `O(n)` because:
    - Inserting all elements into the set takes `O(n)`.
    - Iterating through the set and checking consecutive elements also takes `O(n)` since each element is processed only once.
- **Space Complexity**: The space complexity is `O(n)` due to the storage required for the set.

This is the most efficient solution in terms of both time and space.

---
