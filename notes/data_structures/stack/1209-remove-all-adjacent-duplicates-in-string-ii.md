Given a string and an integer `k`, repeatedly remove every **exactly `k` identical adjacent characters**. After each removal, the characters on either side can become adjacent and might now form another group of `k`, so removals cascade until no group of `k` identical letters touches each other. Return the final string.

[Leetcode 1209](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/).

### The key insight

This is a string-reduction problem where grouping depends on the order of processing: removals chain together. That's a perfect fit for a **stack**, because after you pop a completed group, the character before it becomes the new top and can immediately be compared against whatever comes next.

### Approach

The stack stores pairs `(character, count)` instead of single characters.

1. Walk through each character `c`.
2. If the top of the stack holds the same character `c`, increment its count.
   - If the count reaches `k`, pop the whole group (it's fully removed).
3. Otherwise push a new pair `(c, 1)`.
4. At the end, the stack contains the surviving characters and their counts. Repeat each character `count` times to rebuild the string.

### Example

```
s = "deeedbbcccbdaa", k = 3

d  → stack [(d,1)]
e  → [(d,1),(e,1)]
e  → [(d,1),(e,2)]
e  → e count hits 3 → pop  → [(d,1)]
d  → [(d,2)]
b  → [(d,2),(b,1)]
b  → [(d,2),(b,2)]
c  → [(d,2),(b,2),(c,1)]
c  → [(d,2),(b,2),(c,2)]
c  → c hits 3 → pop → [(d,2),(b,2)]
b  → [(d,2),(b,3)] → b hits 3 → pop → [(d,2)]
d  → [(d,3)] → hits 3 → pop → []
a  → [(a,1)]
a  → [(a,2)]

result: "aa"
```

### Code Implementation

```java
class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<int[]> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek()[0] == c) {
                stack.peek()[1]++;
                if (stack.peek()[1] == k) {
                    stack.pop();
                }
            } else {
                stack.push(new int[]{c, 1});
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] arr : stack) {
            char c = (char) arr[0];
            for (int i = 0; i < arr[1]; i++) {
                sb.append(c);
            }
        }

        return sb.reverse().toString();
    }
}
```

(The stack is read top-down, so the final `StringBuilder` is reversed to get the correct left-to-right order.)

### Complexity

- **Time:** O(n), each character pushed and popped at most once.
- **Space:** O(n) for the stack.

### Conclusion

Keeping a per-character running count on the stack lets us detect and remove runs of exactly `k` in one pass, and pops automatically speed the grouping cascade between the left and right sides.