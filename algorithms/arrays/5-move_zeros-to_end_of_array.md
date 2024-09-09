Here’s a refined version of your notes with improved clarity and flow:

---

### Problem: Move Zeroes to the End
You are given an array `[1, 0, 2, 3, 2, 0, 0, 4, 5, 1]`. Your goal is to move all zeros to the end of the array, such that the new array becomes `[1, 2, 3, 2, 4, 5, 1, 0, 0, 0]`. All non-zero elements should retain their original order.

This is based on **Leetcode 283: Move Zeroes**.

---

### 1. **Brute Force Solution**:
The brute force approach involves using an additional temporary array to store non-zero elements, followed by rearranging the original array.

#### Steps:
1. Iterate through the original array, storing all non-zero elements in a temporary array.
2. Copy the elements from the temporary array back into the original array, starting from the beginning.
3. Fill the remaining spaces with `0`s.

#### Pseudocode:
```pseudocode
// Step 1 - Store non-zero elements in a temporary array
temp = []
for(int i = 0; i < n; i++){
    if(arr[i] != 0){
        temp.add(arr[i])
    }
}

// Step 2 - Copy elements from temp to the original array
for(int i = 0; i < temp.size(); i++){
    arr[i] = temp[i];
}

// Step 3 - Fill the rest of the array with 0's
numOfNonZeroElements = temp.size()

for(int i = numOfNonZeroElements; i < n; i++){
    arr[i] = 0;
}
```

This approach has a time complexity of **O(n)** due to the two loops, but it also uses extra space of **O(n)** due to the temporary array.

---

### 2. **Optimal Solution: Two Pointer Approach**:
A more efficient solution is to avoid the temporary array and solve the problem in-place using two pointers.

#### Idea:
- Use one pointer (`j`) to track the position of the first zero in the array.
- Use a second pointer (`i`) to iterate through the array starting from the element after `j`.
- Every time a non-zero element is found at `i`, swap it with the element at `j`. This ensures that all non-zero elements are moved to the front, and zeros are shifted to the end.

#### Steps:
1. Find the first zero in the array and set `j` to its index.
2. Start iterating from `j + 1`. Whenever a non-zero element is found, swap it with the element at `j`.
3. After the swap, increment both `i` and `j`.

#### Pseudocode:
```pseudocode
// Step 1 - Find the index of the first zero
j = -1;
for(int i = 0; i < n; i++){
    if(arr[i] == 0){
        j = i;
        break;
    }
}

// Step 2 - Use two pointers to swap non-zero elements with zeroes
for(int i = j + 1; i < n; i++){
    if(arr[i] != 0){
        // Swap arr[i] with arr[j]
        swap(arr[i], arr[j]);
        j++;  // Move j to the next zero
    }
}
```

#### Explanation:
- The first loop identifies the first occurrence of zero, which will serve as the `j` pointer for swapping.
- The second loop iterates through the array. For each non-zero element found after `j`, the element is swapped with the zero at `j`, and `j` is incremented to track the position of the next zero.

This approach has a time complexity of **O(n)**, and it solves the problem in-place, with **O(1)** additional space.


