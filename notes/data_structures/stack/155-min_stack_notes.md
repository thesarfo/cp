## LeetCode 155: Min Stack

**Problem link:** https://leetcode.com/problems/min-stack/

### The question in plain English

Build a stack that supports the normal `push`, `pop`, `top`, **plus `getMin()` returning the smallest element currently in the stack**, and all four operations must run in O(1).

### The mental model

A stack only lets you touch the top, so `getMin()` can't just scan: it would be O(n). Instead, keep a *second stack* that remembers the minimum seen **as of each push**. Since a pop only ever removes the top, the current min is exactly what that parallel stack stores on top.

If `minstack.peek()` is the smallest value *at the moment that entry was pushed*, then as the real stack shrinks the min shrinks with it: correctly. When a small value is popped, the old min is "restored" because it's sitting right below it in `minstack`.

### How the code works

- `stack`: stores every pushed value (the real stack).
- `minstack`: for every element in `stack`, stores the minimum **among all elements up to and including it**.

```
push(5): stack   [5]        minstack [5]        // min so far = 5
push(3): stack   [5, 3]     minstack [5, 3]     // min(3, 5) = 3
push(4): stack   [5, 3, 4]  minstack [5, 3, 3]  // min(4, 3) = 3
pop():   stack   [5, 3]     minstack [5, 3]     // 4 was never the min
getMin() = minstack.peek() = 3
```

**push(v):** push `v` onto `stack`, and onto `minstack` push `min(v, minstack.peek())`. If `minstack` is empty, push `v`.

**pop():** pop both stacks together: they stay in sync.

**top():** `stack.peek()`.

**getMin():** `minstack.peek()`.

### Complexity

- **Time:** O(1) for every operation.
- **Space:** O(n): one extra entry in `minstack` per element.

### Variation to know

The same idea in one stack: store pairs `(value, minSoFar)` instead of two stacks, or store values as `value - min` and track the running min. The two-stack version is easier to write and explain first.
