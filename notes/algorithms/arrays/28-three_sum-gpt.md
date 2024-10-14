## Triplet Sum to Zero

You are given an integer array, and your task is to find all unique triplets that sum up to zero. A **triplet** refers to an array of three integers.

### Constraints:
- You cannot use the same element more than once (i.e., `i != j != k`).
- You cannot include duplicate triplets; all triplets generated should be unique.

### Example:
**Input Array:**  
```plaintext
[-1, 0, 1, 2, -1, -4]
```

**Expected Output:**  
```plaintext
[[-1, -1, 2], [-1, 0, 1]]
```

**Explanation:**  
In the given array, the unique triplets that sum to zero are:
- `[-1, -1, 2]`
- `[-1, 0, 1]`

**Note:** The triplet `[0, 0, 0]` is not possible in this case since we only have one instance of `0` in the input array.

### Approaches to Solve the Problem

1. **Brute Force Approach**:
   - The brute force method involves trying all possible triplet combinations to find those that sum to zero. This is done using a **three-pointer** approach:
     - The first two pointers start at the first two elements of the array.
     - The third pointer ranges from the second pointer to the end of the array.
     - When the third pointer reaches the end, the second pointer is moved to the right, and the process is repeated.

   - To maintain uniqueness, sort each triplet and store it in a set. Before adding a triplet to the set, check if its sorted version is already present.

   **Pseudocode**:
   ```java
   Set<List<Integer>> uniqueTriplets = new HashSet<>();
   for (i = 0; i < n; i++) {
       for (j = i + 1; j < n; j++) {
           for (k = j + 1; k < n; k++) {
               if (arr[i] + arr[j] + arr[k] == 0) {
                   List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                   Collections.sort(temp);
                   uniqueTriplets.add(temp);
               }
           }
       }
   }
   return new ArrayList<>(uniqueTriplets);
   ```

   **Time Complexity**: \(O(n^3)\)

2. **Optimized Approach Using Hashing**:
   - We can optimize the solution to \(O(n^2)\) by eliminating the third loop.
   - The logic is based on recognizing that if we have two elements, we can deduce the third as:
     \[
     arr[k] = -(arr[i] + arr[j])
     \]
   - We use a set to check for the existence of the third element while iterating through the first two.

   **Implementation**:
   ```java
   Set<List<Integer>> result = new HashSet<>();
   for (i = 0; i < n; i++) {
       Set<Integer> store = new HashSet<>();
       for (j = i + 1; j < n; j++) {
           int third = -(arr[i] + arr[j]);
           if (store.contains(third)) {
               List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
               Collections.sort(temp);
               result.add(temp);
           }
           store.add(arr[j]);
       }
   }
   return new ArrayList<>(result);
   ```

   **Time Complexity**: \(O(n^2)\)  
   **Space Complexity**: \(O(n) + O(n \log n) \times 2\) (due to sorting)

3. **Optimal Solution Using Two Pointers**:
   - First, sort the array.
   - Use two pointers (`j` and `k`) to traverse the array, with `i` fixed at the first element:
     - If the sum of the triplet is less than zero, move the `j` pointer to the right (increase).
     - If the sum is greater than zero, move the `k` pointer to the left (decrease).
     - If a valid triplet is found, store it, then move both pointers inward, ensuring that duplicates are skipped.

   **Implementation**:
   ```java
   List<List<Integer>> answer = new ArrayList<>();
   Arrays.sort(arr);
   for (i = 0; i < n; i++) {
       if (i > 0 && arr[i] == arr[i - 1]) continue; // Skip duplicates
       int j = i + 1;
       int k = n - 1;

       while (j < k) {
           int sum = arr[i] + arr[j] + arr[k];
           if (sum < 0) {
               j++;
           } else if (sum > 0) {
               k--;
           } else {
               List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
               answer.add(temp);
               j++;
               k--;
               while (j < k && arr[j] == arr[j - 1]) j++; // Skip duplicates
               while (j < k && arr[k] == arr[k + 1]) k--; // Skip duplicates
           }
       }
   }
   return answer;
   ```

   **Time Complexity**: \(O(n^2)\)  
   **Space Complexity**: \(O(1)\) (No extra space needed for sets)
