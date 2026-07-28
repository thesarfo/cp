## LeetCode 946 — Validate Stack Sequences

### Problem

Given two sequences `pushed` and `popped`, determine if the `popped` sequence could be the result of a valid sequence of push/pop operations on an initially empty stack.

### Approach

Simulate the stack operations against the `popped` sequence:

1. Push elements from `pushed` onto a stack one by one.
2. After each push, while the top of the stack matches the next element in `popped`, pop it and advance the `popped` pointer.
3. At the end, if the stack is empty, the sequence is valid.

### Why this works

The stack is LIFO, so the only element you can pop at any point is the top. The algorithm greedily pops whenever the top matches the expected popped element — if a different order was intended, a mismatch would occur later and the stack would not empty.

### Example

```
pushed = [1, 2, 3, 4, 5]
popped = [4, 5, 3, 2, 1]
           ↑
           pi

push 1 → stack: [1]          top ≠ 4
push 2 → stack: [1, 2]       top ≠ 4
push 3 → stack: [1, 2, 3]    top ≠ 4
push 4 → stack: [1, 2, 3, 4] top = 4 → pop, pi=1
       → stack: [1, 2, 3]    top = 5? no
push 5 → stack: [1, 2, 3, 5] top = 5 → pop, pi=2
       → stack: [1, 2, 3]    top = 3 → pop, pi=3
       → stack: [1, 2]       top = 2 → pop, pi=4
       → stack: [1]          top = 1 → pop, pi=5
       → stack: []           ✓ valid
```

### Time & space

- Time: O(n) — each element is pushed once and popped at most once.
- Space: O(n) — stack holds elements in the worst case (e.g. strictly increasing pushed/decreasing popped).
