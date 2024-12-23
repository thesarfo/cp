You are given an integer array `nums` of size `n`. Construct a new array `result` where `result[i]` is equal to the product of all elements in the array except `nums[i]`.

#### **Constraints**
1. You must solve it without division.
2. The solution must run in \(O(n)\) time.
3. You can use only \(O(1)\) additional space (excluding the output array).


### **Key Intuitions**
1. **Division Method (Not Allowed Here):**
   - Calculate the product of all elements.
   - For each `i`, set `result[i] = total_product / nums[i]`.
   - However, division is explicitly prohibited here.

2. **Without Division:**
   - Break the problem into two passes:
     1. Compute **prefix product**: The product of all elements to the left of `i`.
     2. Compute **suffix product**: The product of all elements to the right of `i`.
   - Combine prefix and suffix products for each index.

### **Approach: Prefix and Suffix Multiplication**

We can solve the problem in three main steps:
1. Calculate the prefix product for each index.
2. Calculate the suffix product for each index.
3. Multiply prefix and suffix products to get the result.


#### **Steps in Detail**

1. **Initialize the Result Array:**
   - Create an array `result` where `result[i]` will hold the prefix product for index `i`.

2. **Pass 1: Compute Prefix Products:**
   - Traverse from left to right.
   - Compute the product of all elements to the left of the current index.

3. **Pass 2: Compute Suffix Products:**
   - Traverse from right to left.
   - Multiply the prefix product stored in `result` with the suffix product.

This avoids the need for separate prefix and suffix arrays, meeting the \(O(1)\) space requirement.


#### **Code**

```java
public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];

    // Step 1: Compute prefix products
    result[0] = 1; // No product to the left of the first element
    for (int i = 1; i < n; i++) {
        result[i] = result[i - 1] * nums[i - 1];
    }

    // Step 2: Compute suffix products and multiply with prefix
    int suffixProduct = 1; // No product to the right of the last element
    for (int i = n - 1; i >= 0; i--) {
        result[i] *= suffixProduct;
        suffixProduct *= nums[i];
    }

    return result;
}
```

---

# **Example Walkth### **Input**
```plaintext
nums = [1, 2, 3, 4]
```

#### **Prefix Pass**
- Start with `result[0] = 1`.
- Compute prefix products:
  - `result[1] = result[0] * nums[0] = 1 * 1 = 1`
  - `result[2] = result[1] * nums[1] = 1 * 2 = 2`
  - `result[3] = result[2] * nums[2] = 2 * 3 = 6`
  
Result after prefix pass:
```plaintext
result = [1, 1, 2, 6]
```

#### **Suffix Pass**
- Start with `suffixProduct = 1`.
- Compute suffix products while updating `result`:
  - `result[3] = result[3] * suffixProduct = 6 * 1 = 6`
    - Update `suffixProduct = suffixProduct * nums[3] = 1 * 4 = 4`
  - `result[2] = result[2] * suffixProduct = 2 * 4 = 8`
    - Update `suffixProduct = suffixProduct * nums[2] = 4 * 3 = 12`
  - `result[1] = result[1] * suffixProduct = 1 * 12 = 12`
    - Update `suffixProduct = suffixProduct * nums[1] = 12 * 2 = 24`
  - `result[0] = result[0] * suffixProduct = 1 * 24 = 24`

Result after suffix pass:
```plaintext
result = [24, 12, 8, 6]
```
