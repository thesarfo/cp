### Problem Statement

Given a Roman numeral string `s`, convert it to an integer.

[Problem link](https://leetcode.com/problems/roman-to-integer/submissions/1596930620/)

### Roman Numerals Overview

**Symbols and Values**:
- `I` = 1
- `V` = 5
- `X` = 10
- `L` = 50
- `C` = 100
- `D` = 500
- `M` = 1000

**Key Points**:
- Roman numerals are generally written from largest to smallest from left to right.
- However, when a smaller numeral appears before a larger one, it is subtracted. For example:
  - `IV` = 4 (5 - 1)
  - `IX` = 9 (10 - 1)
  - `XL` = 40 (50 - 10)
  - `XC` = 90 (100 - 10)
  - `CD` = 400 (500 - 100)
  - `CM` = 900 (1000 - 100)

### Approach

1. **Initialize a map**: Create a mapping of Roman symbols to their integer values.
2. **Traverse the string**: Iterate through the characters in the Roman numeral string.
3. **Compare values**:
   - If the current numeral is less than the next one, subtract its value.
   - Otherwise, add its value to the total.
4. **Return the total**.

### Implementation in Java

Here’s how to implement the solution:

```java
import java.util.HashMap;

public class RomanToInteger {
    public static int romanToInt(String s) {
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            int value = romanMap.get(s.charAt(i));

            // Check if the next numeral exists and is larger
            if (i + 1 < length && romanMap.get(s.charAt(i + 1)) > value) {
                total -= value; // Subtract if current is less than next
            } else {
                total += value; // Add otherwise
            }
        }

        return total;
    }
}
```

### Notes for Review

1. **Mapping**:
   - Create a `HashMap` to store Roman numeral values for quick lookup.

2. **Traversal**:
   - Loop through the string, checking the current numeral against the next.

3. **Comparison**:
   - If the current numeral is less than the next, subtract its value.
   - Otherwise, add its value to the total.

4. **Edge Cases**:
   - The algorithm handles all valid Roman numerals in the range [1, 3999].

### Complexity
- **Time Complexity**: O(n), where n is the length of the string (one traversal).
- **Space Complexity**: O(1) since the map size is constant and does not depend on input size.