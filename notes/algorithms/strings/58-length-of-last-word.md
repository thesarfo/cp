Given a string `s` made of words (letters) separated by spaces, return the **length of the last word**.

A "word" is a maximal substring of non-space characters. The string may have trailing spaces, so the last word is not necessarily at the very end of the string.

[Leetcode 58](https://leetcode.com/problems/length-of-last-word/).

### The key insight

Instead of scanning the whole string and tracking every word length, scan **from the back**. The last word is found by:

1. Skip trailing spaces.
2. Count letters until we hit a space again: that count is the answer.

This avoids splitting the string or storing anything.

### Approach

1. Start a counter `length = 0`.
2. Iterate from `i = s.length() - 1` down to `0`:
   - If the character is a space:
     - If we've already counted letters (`length > 0`), we've passed the last word → break.
     - Otherwise keep skipping (trailing spaces).
   - If it's a letter, increment `length`.
3. Return `length`.

### Example

```
s = "   fly me   to   the moon  "

start from the end:
'  '  (space, length=0, skip)
'o','o','n' → length = 3
'm'  → length = 4
space → length > 0, break

return 4
```

### Code Implementation

```java
class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (length > 0) break;
                continue;
            }
            length++;
        }
        return length;
    }
}
```

### Complexity

- **Time:** O(n), where `n` is the length of the string.
- **Space:** O(1), no extra storage.

### Conclusion

Walking backwards is the classic trick here: trailing spaces are simply skipped, then every letter counted up to the first space belongs to the last word: giving an answer in a single O(1)-space pass.