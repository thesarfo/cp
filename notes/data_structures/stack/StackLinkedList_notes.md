## Stack (Linked-List-based) — Java

### Why a linked list instead of an array?

The array-based stack has two main drawbacks:
1. **Fixed capacity** — once the array is full, you cannot push more elements unless you manually resize.
2. **Type inflexibility** — the array stores a concrete type (e.g. `int`), so you need a separate class for each type.

A linked-list stack solves both: nodes are allocated on demand (no preset limit), and with generics (`<T>`) the same class works for any type.

### Structure

The stack is a chain of `Node` objects. Each node holds:
- `data` — the actual value
- `next` — a reference to the node below it

```
push(6)   →   [6 | null]
push(2)   →   [2 | ·] → [6 | null]
push(4)   →   [4 | ·] → [2 | ·] → [6 | null]
                ↑
               top
```

The `top` field always points to the most recently inserted node. If the stack is empty, `top` is `null`.

### Operations in detail

**push(T data)**
1. Create a new `Node` with the given data, linking its `next` to the current `top`.
2. Point `top` to the new node.
3. Increment `size`.

Because we link the new node *before* the current top, the list grows upward. The new node becomes the new top.

```
Before: top → [2 | ·] → [6 | null]
After:  top → [4 | ·] → [2 | ·] → [6 | null]
```

Cost: O(1) — just constructing one node and reassigning a reference.

**pop()**
1. If `top == null`, the stack is empty — print a message and return `null`.
2. Save `top.data` as the value to return.
3. Move `top` down one node: `top = top.next`.
4. Decrement `size`.

The old top node is now unreachable and will be garbage-collected.

```
Before: top → [4 | ·] → [2 | ·] → [6 | null]
After:  top → [2 | ·] → [6 | null]
// returns 4
```

Cost: O(1).

**peek()**
1. If `top == null`, return `null`.
2. Return `top.data` without changing any references.

Cost: O(1).

**isEmpty() / size()**
- `isEmpty` checks `top == null`.
- `size` returns the `size` counter, updated on every push/pop.

### Edge cases

| Scenario | Behaviour |
|---|---|
| Pop from empty stack | Prints message, returns `null` |
| Peek into empty stack | Prints message, returns `null` |
| Push onto empty stack | Works fine — `top` is `null`, new node's `next` becomes `null`, `top` points to it |
| Single element, then pop | `top` becomes `null`, size becomes 0. Stack is empty again |

### Comparison: array vs linked-list stack

| Aspect | Array stack | Linked-list stack |
|---|---|---|
| Memory | Contiguous block, may waste space if capacity > usage | Nodes allocated per element, no waste |
| Capacity | Fixed at creation | Grows and shrinks dynamically |
| Type support | Single type per class | Generic — works with any type |
| Cache locality | Good (contiguous memory) | Poor (nodes scattered in heap) |
| Push/Pop cost | O(1) amortised | O(1) per operation |
| Memory per element | Single array slot (4–8 bytes) | Node object ~ 16–24 bytes overhead |

### About generics

`StackLinkedList<T>` means the stack can hold any reference type: `Integer`, `String`, custom objects, etc. The compiler enforces type safety — you cannot accidentally mix types. Because Java generics do not work with primitives directly, use the wrapper types (`Integer`, `Double`, etc.) — autoboxing handles conversion automatically.

### Garbage collection note

When a node is popped, no explicit `delete` or `free` is needed. The node becomes unreachable because nothing references it, and the JVM reclaims its memory during the next GC cycle.
