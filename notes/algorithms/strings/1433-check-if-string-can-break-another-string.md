Given two strings `s1` and `s2`, we want to know if one can "break" the other. String `a` breaks string `b` if, when you line them up position by position, you can rearrange `a` and `b` so that `a[i] >= b[i]` at every index. We return true if `s1` can break `s2`, **or** if `s2` can break `s1`.

[Leetcode 1433](https://leetcode.com/problems/check-if-a-string-can-break-another-string/).

### The key insight

A string "breaks" another if, after sorting both, every character of the first is `>=` the matching character of the second. Sorting is what makes the matching optimal: pairing the sorted orders gives the best possible chance to align letters.

There are exactly two ways to break: `s1` beats `s2`, or `s2` beats `s1`. We test both in a single pass.

### Approach

1. **Sort both strings** into character arrays.
2. **Two flags:** `real` = "s1 >= s2 at every index", `fake` = "s2 >= s1 at every index". Start both as true.
3. **One pass:** compare `s1[i]` and `s2[i]`.
   - If `s1[i] < s2[i]`, then `s1` can't break `s2` → `real = false`.
   - If `s2[i] < s1[i]`, then `s2` can't break `s1` → `fake = false`.
   - Early exit: if **both** flags are false, neither string can break the other, so return `false` right away.
4. Return `real || fake`.

### Example

```
s1 = "abc", s2 = "xya"
sort → s1 = [a, b, c], s2 = [a, x, y]

index 0: a == a  → both still true
index 1: b < x   → real = false
index 2: c < y   → fake = false (x > a, but c < y)

both false → return false (resigns early)
```

Another case:
```
s1 = "leetcode", s2 = "interview"
sort  s1 = [c,d,e,e,e,l,o,t]
sort  s2 = [e,e,e,i,n,r,t,v]
```
Here `s2` beats `s1` at every position, so return true.

### Code Implementation

```java
class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] s1arr = s1.toCharArray();
        char[] s2arr = s2.toCharArray();

        Arrays.sort(s1arr);
        Arrays.sort(s2arr);

        boolean real = true;   // s1 can break s2
        boolean fake = true;   // s2 can break s1

        for (int i = 0; i < s1arr.length; i++) {
            if (s1arr[i] < s2arr[i]) real = false;
            if (s2arr[i] < s1arr[i]) fake = false;

            if (!real && !fake) return false;
        }

        return real || fake;
    }
}
```

### Complexity

- **Time:** O(n log n) for the two sorts, O(n) for the pass → overall O(n log n).
- **Space:** O(n) for the char arrays.

### Conclusion

Sorting turns the pairwise "break" check into a simple element-wise comparison, and tracking both directions lets us answer the question with a single clean loop instead of running it twice.