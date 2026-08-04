## LeetCode 225: Implement Stack using Queues

### Problem

Build a LIFO stack using only FIFO queues (standard queue operations: `offer`, `poll`, `peek`, `isEmpty`).

### Strategy: Two-queue push-heavy approach

Use two queues `q1` and `q2`. `q1` always holds elements in stack order (most recent at front).

**push(x)**
1. Enqueue `x` into `q2` (the empty auxiliary queue).
2. Move all elements from `q1` to `q2`: this places `x` at the front of `q2`.
3. Swap the references so `q1` points to the queue with stack-order and `q2` becomes empty.

```
push(1): q1 = [1]           q2 = []
push(2): q1 = [2, 1]        q2 = []
push(3): q1 = [3, 2, 1]     q2 = []
         (front) → (rear)
```

**pop()**: `q1.poll()` removes the front (most recently pushed element).
**top()**: `q1.peek()` returns the front.
**empty()**: `q1.isEmpty()`.

### Time & space

- push: O(n): moves n elements per push.
- pop / top: O(1).
- Space: O(n) for the two queues combined.

### Alternative: single-queue approach

Push can be done with one queue by rotating:

```java
public void push(int x) {
    q.offer(x);
    for (int i = 0; i < q.size() - 1; i++) {
        q.offer(q.poll());
    }
}
```

Same cost (O(n) push, O(1) pop), but saves one queue reference.
