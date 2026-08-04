## LeetCode 3517: Smallest Palindromic Rearrangement I

### Problem

Given a **palindromic** string `s`, return the lexicographically smallest palindrome that can be formed by rearranging its characters.

### Key insight

Since `s` is already a palindrome, each character appears an even number of times (except at most one odd-count character that sits in the middle). The string is fully determined by its left half: the right half is just a mirror.

To get the smallest lexicographic palindrome:
1. Sort the first half of characters in ascending order.
2. Mirror them to the right half.

### Approach in code

```
len = s.length()
partition = len / 2

chars = s.toCharArray()
sort chars[0 .. partition)           // sort left half ascending

for i = 0 .. partition-1
    chars[len - 1 - i] = chars[i]   // mirror left half to right side

return new String(chars)
```

### Why this works

Because the input is palindromic, the multiset of characters is already symmetric. Sorting just the left half and mirroring it guarantees:

- The result is a palindrome (by construction).
- It's the smallest possible palindrome: any smaller candidate would differ at some position in the left half, but we've placed the smallest available characters there.

### Time & space

- Time: O(n log n): sorting the left half dominates.
- Space: O(n): the char array.
