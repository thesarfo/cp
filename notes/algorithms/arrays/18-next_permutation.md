You are given an array of integers, and the task is to find the **next permutation** of that array. So, what exactly is a **permutation**? Simply put, a permutation refers to the different ways you can rearrange the elements of an array. For example, if we take the array `[3, 1, 2]`, the possible permutations would include `[1, 2, 3]`, `[1, 3, 2]`, and so on.

Now, when we talk about the **next permutation**, we're referring to the next possible arrangement of the array elements in lexicographical order. In simpler terms, it’s the next possible "larger" arrangement. Let’s use the array `[3, 1, 2]` to explain:

For example, the permutations of the array `[3, 1, 2]` are:

* `[1, 2, 3]`
* `[1, 3, 2]`
* `[2, 1, 3]`
* `[2, 3, 1]`
* `[3, 1, 2]`
* `[3, 2, 1]`

So, the **next permutation** of `[3, 1, 2]` is `[3, 2, 1]`.

If the input array was `[3, 2, 1]`, we know there is no next permutation for this, so we can just fall back to the very first possible permutation of the array. Therefore our answer will be `[1, 2, 3]`

**Note**: The total number of permutations for an array of length `n` is `n!` `(factorial of n)`. This means the time complexity to generate all permutations is `O(n! * n)`, which becomes computationally expensive for large arrays.

1. **Brute Force Solution**: We can generate all the possible permutations in sorted order, then look for where our input array lies(via linear search), and then the next index permutation will be our answer. If the next permutation doesn't exist, we simply return the first permutation. We can use **recursion** to generate all the possible permutations

2. **Optimal Solution**:  A more efficient approach involves using a **longer prefix match** to find the next permutation without generating all permutations. Let's use the array `[2, 1, 5, 4, 3, 0, 0]` as an example to explain:

   - **Step 1**: Find the **breakpoint**, which is the first index `i` from the right where `arr[i] < arr[i + 1]`. This is the point where the array stops decreasing when moving from right to left. In `[2, 1, 5, 4, 3, 0, 0]`, the breakpoint is at index `1` (`arr[1] = 1` because `1 < 5`).
   
   - **Step 2**: After finding the breakpoint, look for the smallest number **just greater** than `arr[i]` (the number at the breakpoint). In this case, the next larger number than `1` is `3` (found at index `4`).
   
   - **Step 3**: Swap the numbers at these two indices. Swapping `1` and `3` gives us the array `[2, 3, 5, 4, 1, 0, 0]`.
   
   - **Step 4**: Reverse the portion of the array after index `i` to get the smallest lexicographically larger permutation. Reversing the part after index `1` (`[5, 4, 1, 0, 0]`) results in `[0, 0, 1, 4, 5]`.

   The final array is `[2, 3, 0, 0, 1, 4, 5]`, which is the **next permutation** after `[2, 1, 5, 4, 3, 0, 0]`.