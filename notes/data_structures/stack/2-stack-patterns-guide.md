# Stacks: Study Guide

A stack is a linear data structure that follows **LIFO (Last In, First Out)**: the last element pushed is the first one popped. It's like a stack of plates: you can only take the one on top.

The core mental shift for stack problems: **the stack remembers what came before**, in reverse order. Whenever a problem talks about matching, undoing, or "the most recent thing", a stack is usually the answer.

## Stack Fundamentals

Three operations, all O(1):

```java
push(x)   // put x on top
pop()     // remove and return the top
peek()    // look at the top without removing it
```

**In Java**, prefer `ArrayDeque` over the legacy `Stack` class (it's faster and not restricted to being synchronized):

```java
Deque<Integer> stack = new ArrayDeque<>();
stack.push(1);
stack.pop();       // returns 1
stack.peek();      // top element without removing
```

**Array vs Linked List implementation:**
- Array-based: fast access, but fixed capacity unless you resize (double the array when full).
- Linked-list-based: grows freely, no resizing, but each node carries overhead.

Both give O(1) push/pop. The choice rarely matters in interviews: what matters is recognizing *when* to use a stack.

---

## The 7 Stack Patterns

### 1. Matching / Balanced Symbols

**What:** problems that ask "are these symbols/things properly paired and nested?"
**Why a stack:** when you see an *opening* symbol, push it; when you see a *closing* one, pop and check it matches. The stack naturally mirrors nesting: the most recent opener is the first to be closed.

```java
// Valid Parentheses (20): match ( { [
for (char ch : s.toCharArray()) {
    if (ch == '(' || ch == '{' || ch == '[') stack.push(ch);
    else {
        if (stack.isEmpty()) return false;          // closing with nothing open
        if (!matches(stack.pop(), ch)) return false; // wrong pair
    }
}
return stack.isEmpty();  // nothing left unclosed
```

**Variants:** removing adjacent duplicates (1047) is the same idea but "pairs" are equal letters: push, and pop when the top equals the incoming char.

### 2. Simulation / Undo

**What:** problems where you process a sequence and sometimes need to *undo* or *go back* (browser history, ".." in a path, backspace keys).
**Why a stack:** undo is literally "pop the most recent action". Simulate the sequence forward, pushing each result; whenever something says "go back / remove previous", pop.

```java
// Backspace String Compare (844)
for (char ch : s.toCharArray()) {
    if (ch == '#') { if (!stack.isEmpty()) stack.pop(); }
    else stack.push(ch);
}
```

### 3. Monotonic Stack ⭐⭐⭐⭐⭐

**What:** a stack whose elements are kept sorted (always increasing or always decreasing from bottom to top). Used to find the **next/previous greater/smaller element** for every element, in O(n) instead of O(n²).

**Why it matters:** "find the next greater element to the right" naively is two nested loops. With a monotonic stack, each element is pushed and popped at most once.

**The core trick: how "Next Greater" works:**

```java
int[] nextGreater(int[] arr) {
    int[] res = new int[arr.length];
    Arrays.fill(res, -1);
    Deque<Integer> stack = new ArrayDeque<>();   // holds indices
    for (int i = 0; i < arr.length; i++) {
        // while current is greater than top, top's next greater is found:
        while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
            res[stack.pop()] = arr[i];
        }
        stack.push(i);   // index, not value: you need position too
    }
    return res;
}
```

**Rules of thumb:**
- Stack increasing (bottom→top) → finds *previous smaller* and *next smaller*.
- Stack decreasing → finds *previous greater* and *next greater*.
- Keep **indices** on the stack, not values, so you can compute distances (Daily Temperatures 739 = "how many days until warmer").

**Signature problems:** Daily Temperatures (739), Next Greater Element I/II (496, 503), Online Stock Span (901), Largest Rectangle in Histogram (84), Trapping Rain Water (42). Master this one pattern and five medium/hard problems collapse.

### 4. Expression Evaluation

**What:** parsing arithmetic. Postfix (Reverse Polish) needs only an **operand stack**: no parentheses, no precedence.

```java
// Evaluate Reverse Polish Notation (150)
for (String token : tokens) {
    if (token is a number) stack.push(Integer.parseInt(token));
    else {
        int b = stack.pop();   // note order: b is the second operand
        int a = stack.pop();
        stack.push(apply(a, token, b));
    }
}
return stack.pop();
```

**Why it works:** operators come *after* their operands in postfix, so when you hit an operator its two operands are already on top of the stack.

### 5. Recursion → Explicit Stack

**What:** recursion uses the call stack automatically. Any recursive traversal can be rewritten iteratively with an explicit stack (important for avoiding stack overflow on deep recursion).

**Why learn it:** some problems are easier to *think* about with a manual stack, and interviews like asking for iterative versions. Example: iterative preorder DFS on a binary tree: push root, pop, push right then left.

### 6. Stack + Extra Information

**What:** instead of storing just values, store a small struct: `(value, index)`, `(value, minimum-so-far)`, etc.

**Why:** some problems need context *alongside* the value. Min Stack (155) is the classic: store pairs `(value, currentMin)` so `getMin()` is O(1): the stack remembers the min as of each push.

```java
Deque<int[]> stack = new ArrayDeque<>(); // {value, minSoFar}
push(x): stack.push(new int[]{x, Math.min(x, minSoFar)});
getMin(): return stack.peek()[1];
```

### 7. Advanced Stack Design

**What:** building other data structures out of stacks, or designing stacks with unusual behavior (232 Queue using Stacks, 946 Validate Stack Sequences, 1381 Increment stack).

**Why:** combines everything: you have to think about *when* things move between stacks and how operations compose.

---

## Pattern Recognition Cheat Sheet

| If the problem mentions... | Use | Example |
|---|---|---|
| matching / nested pairs | matching stack | Valid Parentheses, Decode String |
| undo / back / history | simulation stack | Simplify Path, Browser History |
| next/previous greater or smaller | monotonic stack | Daily Temperatures, Largest Rectangle |
| arithmetic without parens | operand stack | Evaluate RPN |
| iterating a recursion | explicit stack | Iterative tree DFS |
| O(1) queries while pushing | stack of tuples | Min Stack |
| designing a custom stack/queue | compose operations | Queue using Stacks |

## Practice Roadmap (stages, in order)

1. **Fundamentals:** Implement Stack with Array, with Linked List, [225 Implement Stack using Queues](https://leetcode.com/problems/implement-stack-using-queues/)
2. **Matching:** [20 Valid Parentheses](https://leetcode.com/problems/valid-parentheses/), [1047 Remove All Adjacent Duplicates](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/), [1021 Remove Outermost Parentheses](https://leetcode.com/problems/remove-outermost-parentheses/), [394 Decode String](https://leetcode.com/problems/decode-string/)
3. **Simulation / Undo:** [71 Simplify Path](https://leetcode.com/problems/simplify-path/), [1472 Design Browser History](https://leetcode.com/problems/design-browser-history/), [844 Backspace String Compare](https://leetcode.com/problems/backspace-string-compare/)
4. **Monotonic Stack** ⭐: [496 Next Greater Element I](https://leetcode.com/problems/next-greater-element-i/), [503 Next Greater Element II](https://leetcode.com/problems/next-greater-element-ii/), [739 Daily Temperatures](https://leetcode.com/problems/daily-temperatures/), [901 Online Stock Span](https://leetcode.com/problems/online-stock-span/), [84 Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/), [42 Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/)
5. **Expression Evaluation:** [150 Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/)
6. **Recursion & Call Stack:** iterative tree traversals (preorder, inorder, postorder)
7. **Stack + Extra Info:** [155 Min Stack](https://leetcode.com/problems/min-stack/), [735 Asteroid Collision](https://leetcode.com/problems/asteroid-collision/), [856 Score of Parentheses](https://leetcode.com/problems/score-of-parentheses/)
8. **Advanced:** [232 Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/), [946 Validate Stack Sequences](https://leetcode.com/problems/validate-stack-sequences/), [1381 Design a Stack With Increment Operation](https://leetcode.com/problems/design-a-stack-with-increment-operation/)

## Must-Know Before an Interview

If you can solve these without help you are in good shape:

[20](https://leetcode.com/problems/valid-parentheses/), [155](https://leetcode.com/problems/min-stack/), [1047](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/), [844](https://leetcode.com/problems/backspace-string-compare/), [71](https://leetcode.com/problems/simplify-path/), [496](https://leetcode.com/problems/next-greater-element-i/), [739](https://leetcode.com/problems/daily-temperatures/), [901](https://leetcode.com/problems/online-stock-span/), [84](https://leetcode.com/problems/largest-rectangle-in-histogram/), [42](https://leetcode.com/problems/trapping-rain-water/), [150](https://leetcode.com/problems/evaluate-reverse-polish-notation/)

## The One Piece of Advice

A stack's job is to give you the **most recent thing first**. When a problem involves nesting, undo, or "find the next/previous something", ask "can the most-recently-seen element tell me the answer?": if yes, a stack (and often a monotonic one) is the tool.
