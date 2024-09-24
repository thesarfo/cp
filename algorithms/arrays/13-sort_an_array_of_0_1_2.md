You are given an array containing only 0s, 1s, and 2s, for example: `[0, 1, 2, 0, 1, 2, 1, 2, 0, 0, 1]`. Your goal is to sort the array so that all the 0s come first, followed by the 1s, and then the 2s.

[Leetcode 75](https://leetcode.com/problems/sort-colors/)

1. **Brute Force Solution**: 
   - You can apply any general sorting algorithm, such as `merge sort`, to sort the array. However, this approach is less efficient because sorting algorithms typically run in `O(n log n)` time complexity, which is unnecessary given the specific nature of the input.

2. **Better Solution**: 
   - Since the array only contains three distinct elements (0, 1, and 2), we can solve this problem in a single pass using a counting approach:
     - Initialize three counters: `count0`, `count1`, and `count2` to keep track of the number of 0s, 1s, and 2s in the array.
     - Iterate through the array once. For each element, increase the respective counter:
       - If the element is `0`, increment `count0`.
       - If the element is `1`, increment `count1`.
       - If the element is `2`, increment `count2`.
     - By the end of the iteration, the counters will store the frequency of 0s, 1s, and 2s in the array.
     - Now, overwrite the array by filling in `count0` number of 0s, followed by `count1` number of 1s, and finally `count2` number of 2s.

3. **Optimized Solution**: This approach will use the Dutch National Flag(DNF) algorithm. This algorithm uses 3 pointers(low, mid, high), and has 3 rules behind it. First, everything from `[0 - low-1]` will be `0`, everything from `[low - mid-1]` will be `1` and everything from `[high+1 - n-1]` will be `2`

- **Three Pointers**:
  - `low`: Represents the boundary between 0s and 1s. Everything before `low` will be 0s.
  - `mid`: Represents the current element being processed. Everything between `low` and `mid` is guaranteed to be 1s.
  - `high`: Represents the boundary between 1s and 2s. Everything after `high` will be 2s.

#### **The Process**:
1. **Initialization**:
   - Start with three pointers: `low = 0`, `mid = 0`, and `high = n - 1` (where `n` is the size of the array).

2. **While Loop**:
   - Iterate through the array using the `mid` pointer. There are three cases to handle:
   
   **a. If `arr[mid] == 0`:**
   - Swap `arr[mid]` with `arr[low]` to move the `0` to the beginning.
   - Increment both `low` and `mid` because the `0` is now in its correct position, and you can safely move on to the next element.
   
   **b. If `arr[mid] == 1`:**
   - Leave it as is since `1` is already in the correct middle section.
   - Simply increment `mid` to continue processing.

   **c. If `arr[mid] == 2`:**
   - Swap `arr[mid]` with `arr[high]` to move the `2` to the end.
   - Decrement `high`, but don't increment `mid` because the new element at `mid` (after swapping) needs to be checked again.

3. **Termination**:
   - Continue this process until `mid` surpasses `high`, at which point the array will be sorted with all 0s first, followed by 1s, and then 2s.

#### **Time Complexity**: `O(n)`
- Since we only pass through the array once, this solution runs in linear time.

#### **Space Complexity**: `O(1)`
- The algorithm operates in constant space because we are sorting the array in place without using any additional data structures.

#### **Example Walkthrough**:

Consider the array: `[2, 0, 1, 2, 0, 1, 0, 2]`

**Initial State**:
- `low = 0`, `mid = 0`, `high = 7`
- Array: `[2, 0, 1, 2, 0, 1, 0, 2]`

**Step 1**: `arr[mid] = 2`, swap with `arr[high]`, decrease `high`:
- Array: `[2, 0, 1, 2, 0, 1, 0, 2]`, `low = 0`, `mid = 0`, `high = 6`

**Step 2**: `arr[mid] = 2`, swap with `arr[high]`, decrease `high`:
- Array: `[0, 0, 1, 2, 0, 1, 2, 2]`, `low = 0`, `mid = 0`, `high = 5`

**Step 3**: `arr[mid] = 0`, swap with `arr[low]`, increase both `low` and `mid`:
- Array: `[0, 0, 1, 2, 0, 1, 2, 2]`, `low = 1`, `mid = 1`, `high = 5`

**Step 4**: `arr[mid] = 0`, swap with `arr[low]`, increase both `low` and `mid`:
- Array: `[0, 0, 1, 2, 0, 1, 2, 2]`, `low = 2`, `mid = 2`, `high = 5`

**Step 5**: `arr[mid] = 1`, just increase `mid`:
- Array: `[0, 0, 1, 2, 0, 1, 2, 2]`, `low = 2`, `mid = 3`, `high = 5`

**Step 6**: `arr[mid] = 2`, swap with `arr[high]`, decrease `high`:
- Array: `[0, 0, 1, 1, 0, 2, 2, 2]`, `low = 2`, `mid = 3`, `high = 4`

**Step 7**: `arr[mid] = 1`, just increase `mid`:
- Array: `[0, 0, 1, 1, 0, 2, 2, 2]`, `low = 2`, `mid = 4`, `high = 4`

**Step 8**: `arr[mid] = 0`, swap with `arr[low]`, increase both `low` and `mid`:
- Array: `[0, 0, 0, 1, 1, 2, 2, 2]`, `low = 3`, `mid = 5`, `high = 4`

At this point, the array is sorted, and the algorithm terminates.
