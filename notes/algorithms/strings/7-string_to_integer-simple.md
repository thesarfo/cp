### **Problem:**

Convert a string into an integer (`int`), similar to C’s `atoi`.


### **Steps:**

1. **Init**

   * `index = 0` (current position in string)
   * `total = 0` (result we’re building)
   * `sign = 1` (default +ve)

2. **Skip spaces**

   * While char is `' '`, move forward.

3. **Check sign**

   * If `+` → sign = 1
   * If `-` → sign = -1
   * Move forward.

4. **Convert digits**

   * While char is a digit:

     * `digit = char - '0'`
     * Check for overflow (see below)
     * `total = total * 10 + digit`
   * Stop if non-digit.

5. **Return result**

   * `return total * sign`


### **Overflow check**

Before adding the digit, ensure `total` won’t exceed `int` limit:

```java
if (total > Integer.MAX_VALUE / 10 ||
   (total == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
    return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
}
```

Meaning:

* If `total` already bigger than `214748364` → multiplying by 10 will overflow.
* If `total == 214748364` and digit > 7 → also overflow.
* Clamp result:

  * If positive → `Integer.MAX_VALUE (2147483647)`
  * If negative → `Integer.MIN_VALUE (-2147483648)`


### **Why multiply by sign at the end?**

* `"123"` → total = 123, sign = 1 → `123 * 1 = 123`
* `"-123"` → total = 123, sign = -1 → `123 * -1 = -123`


### **Final Pseudocode**

```
1. skip spaces
2. check if + or - (save sign)
3. read digits:
     - digit = char - '0'
     - check overflow
     - total = total * 10 + digit
4. return total * sign
```

That’s it. Simple pipeline: **trim → sign → digits → clamp → sign multiply → return**.