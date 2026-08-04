## LeetCode 946: Validate Stack Sequences

**Problem link:** https://leetcode.com/problems/validate-stack-sequences/

### The question in plain English

You have two lists of numbers:

- `pushed`: the order you *must* push numbers onto a stack
- `popped`: the order you *want* to pop numbers off the stack

You can interleave pushes and pops however you like, but you must push in the given order. Can you end up with the `popped` order?

### The mental model

Imagine a stack of plates. You get a pile of plates (`pushed`) and you must add them to the stack in that exact order. While you're doing that, someone asks you to hand them plates: but they can only take the top plate (`popped`).

You can decide *when* to hand over a plate. The question is: can you satisfy their requests?

**Example:**
```
pushed = [1, 2, 3, 4, 5]
popped = [4, 5, 3, 2, 1]

1. Push 1.                stack: [1]
2. Push 2.                stack: [1, 2]
3. Push 3.                stack: [1, 2, 3]
4. Push 4.                stack: [1, 2, 3, 4]
5. Pop 4 → matches!       stack: [1, 2, 3]
6. Push 5.                stack: [1, 2, 3, 5]
7. Pop 5 → matches!       stack: [1, 2, 3]
8. Pop 3 → matches!       stack: [1, 2]
9. Pop 2 → matches!       stack: [1]
10. Pop 1 → matches!      stack: []

All matched → valid ✓
```

### The trick (simple version)

Just simulate it. Push numbers one by one. After each push, if the top of the stack matches the next number you need to pop: pop it. Keep popping as long as it matches. At the end, if the stack is empty, the sequence works.

### Why this makes sense

The stack only lets you access the most recent item (LIFO). So when you need to pop a number, it *must* be the top of the stack. The only way to get it to the top is to push numbers until it gets there, then pop it immediately (or pop things above it first).

The greedy approach (pop whenever you can) works because if a pop is valid now, delaying it never helps: it only risks blocking numbers underneath.

### Complexity

- **Time:** O(n): each number pushed once, popped at most once.
- **Space:** O(n): stack size in the worst case.
