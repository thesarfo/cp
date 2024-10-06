Given an integer `num`, the task is to repeatedly add all its digits until the result has only one digit, and then return that result.

[Leetcode 258](https://leetcode.com/problems/add-digits/description/)

### Key Concepts:

1. **Digit Sum**: 
   - To solve the problem, you need to continuously sum the digits of the number until you get a single-digit result. For example, for the number `38`:
     - \( 38 \rightarrow 3 + 8 = 11 \)
     - \( 11 \rightarrow 1 + 1 = 2 \)
   - The process stops when the number is reduced to a single digit.

2. **Mathematical Insight (Digital Root)**:
   - There is a mathematical property known as the "digital root" that helps solve this problem without needing to simulate the process manually.
   - **Digital Root Formula**:
     - For any number `num`, the digital root can be calculated directly using the formula:
       - If `num == 0`, the result is `0`.
       - If `num % 9 == 0`, the result is `9` (except when `num` is `0`).
       - Otherwise, the result is `num % 9`.

   This formula allows us to avoid iterative or recursive summing of the digits, providing a very efficient solution.

### Approach:

- **Direct Formula Approach**:
  - If the number is `0`, return `0` immediately.
  - If the number is divisible by `9`, return `9` (as this indicates that the sum of the digits will ultimately reduce to `9`).
  - Otherwise, return `num % 9`.

### Solution:

```java
class Solution {
    public int addDigits(int num) {
        if (num == 0) return 0; // Special case for 0
        if (num % 9 == 0) return 9; // If num is divisible by 9 and not 0
        return num % 9; // Return the digital root for non-multiples of 9
    }
}
```

### Explanation:

1. **`if (num == 0)`**: 
   - Handles the special case where the number is `0`. In this case, the sum of its digits is also `0`, so we return `0`.

2. **`if (num % 9 == 0)`**:
   - Checks if the number is divisible by `9`. If true, return `9`. This condition arises from the properties of numbers divisible by `9` (their digital root is always `9`).

3. **`return num % 9`**:
   - For all other numbers, return `num % 9` which gives the digital root directly.

### Time Complexity:

- **Time Complexity**: \( O(1) \) — The solution uses only a few arithmetic operations, making it constant time.
- **Space Complexity**: \( O(1) \) — The solution does not require any additional space beyond the input number.

### Example:

1. **Input**: `num = 38`
   - First sum of digits: \( 3 + 8 = 11 \)
   - Second sum of digits: \( 1 + 1 = 2 \)
   - Output: `2`
   - Using the formula: \( 38 \% 9 = 2 \)

2. **Input**: `num = 0`
   - Since the input is `0`, the result is `0`.

### Why This Works:
The modulo 9 operation helps compute the digital root because of how digits in a number relate to modulo arithmetic properties, especially with numbers divisible by 9. Instead of summing digits repeatedly, the mathematical shortcut of digital roots leads directly to the correct answer.

