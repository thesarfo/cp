We are given an array of integers, `nums`. For each index \(i\), we need to calculate the product of all elements in the array except the one at \(i\).

[Leetcode Problem](https://leetcode.com/problems/product-of-array-except-self/description/)

**Constraints:**
1. **No division:** This means we can’t use the total product of all elements and divide by `nums[i]`.
2. **O(n) time:** The solution must process the array efficiently in a single pass or a few passes.
3. **Space optimization (Follow-up):** We should aim for \(O(1)\) extra space.


### 1. Brute Force Solution:
#### Idea:
- For each element, loop through the array to calculate the product of all elements except the current one.
- While simple, this involves a nested loop, making it very slow for large arrays.

#### Steps:
1. Create an output array.
2. For each index \(i\), compute the product of all elements by looping through the array and skipping \(i\).
3. Add the result to the output array.

#### Code:
```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }
            answer[i] = product;
        }

        return answer;
    }
}
```

#### Time Complexity:
- **O(n²):** For each element, you loop through the array.

#### Space Complexity:
- **O(n):** For the output array.

This is not a good approach and can be optimized further


### 2. Improved Solution (Prefix and Suffix Arrays):
#### Idea:
- Use two arrays: `prefix` and `suffix`.
- `prefix[i]` stores the product of all elements to the left of index \(i\).
- `suffix[i]` stores the product of all elements to the right of index \(i\).
- The result for any index \(i\) is `prefix[i] * suffix[i]`.

#### Steps:
1. Compute the `prefix` array:
   - `prefix[i] = prefix[i - 1] * nums[i - 1]`.
   - Start with `prefix[0] = 1` because there are no elements to the left of index 0.
2. Compute the `suffix` array:
   - `suffix[i] = suffix[i + 1] * nums[i + 1]`.
   - Start with `suffix[n - 1] = 1` because there are no elements to the right of the last index.
3. Multiply `prefix` and `suffix` arrays to get the result.

#### Code:
```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] answer = new int[n];

        // Build prefix array
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        // Build suffix array
        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        // Multiply prefix and suffix arrays
        for (int i = 0; i < n; i++) {
            answer[i] = prefix[i] * suffix[i];
        }

        return answer;
    }
}
```

#### Time Complexity:
- **O(n):** Two passes for prefix and suffix arrays, one pass to compute the result.

#### Space Complexity:
- **O(n):** For `prefix` and `suffix` arrays.


### 3. Optimal Solution (Space-Optimized):
#### Idea:
- Instead of creating separate `prefix` and `suffix` arrays, reuse the `answer` array for prefix calculations.
- Use a single variable to keep track of the suffix product while traversing the array from right to left.

#### Steps:
1. Compute the prefix products directly in the `answer` array:
   - `answer[i] = prefix[i]` where `prefix[i]` is the product of all elements to the left of \(i\).
   - Start with `answer[0] = 1`.
2. Traverse the array backward to compute suffix products:
   - Keep a `suffixProduct` variable that starts as 1.
   - Multiply `answer[i]` by `suffixProduct` as you iterate backward.
   - Update `suffixProduct` as `suffixProduct *= nums[i]`.

#### Code:
```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Compute prefix products in the answer array
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Compute suffix products and multiply
        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return answer;
    }
}
```

#### Time Complexity:
- **O(n):** Single pass for prefix and suffix calculations.

#### Space Complexity:
- **O(1):** Uses only the output array for storage, apart from a single variable for the suffix product.


### Summary of Approaches:
1. **Brute Force:**
   - Very simple but slow.
   - Uses nested loops to calculate the product for every index.
2. **Prefix + Suffix Arrays:**
   - Calculates prefix and suffix products in separate arrays.
   - Combines the results for \(O(n)\) time complexity.
3. **Space-Optimized Solution:**
   - Combines prefix and suffix calculations into one array, using minimal extra space.



### Key Concepts to Remember:
1. **Prefix Products:** Cumulative product of all elements to the left of the current index.
2. **Suffix Products:** Cumulative product of all elements to the right of the current index.
3. **Optimization:** Reuse the result array to reduce memory usage without affecting clarity.