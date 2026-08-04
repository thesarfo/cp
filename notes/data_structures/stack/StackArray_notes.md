## Stack (Array-based): Java

### Fields
- `arr[]`: fixed-size integer array to hold stack elements
- `top`: index of the top element; `-1` when empty
- `capacity`: maximum number of elements the stack can hold

### Constructor
`StackArray(int size)`: allocates the array and sets `top = -1`.

### Operations

**push(int x)**
1. Check if `top == capacity - 1` (stack full). If full, print message and return.
2. Increment `top`, then place `x` at `arr[top]`.

Time: O(1)

**pop()**
1. Check if `top == -1` (stack empty). If empty, print message and return `-1`.
2. Return `arr[top]`, then decrement `top`.

Time: O(1)

**peek()**
1. Check if `top == -1`. If empty, print message and return `-1`.
2. Return `arr[top]` without modifying `top`.

Time: O(1)

### Limitations
- Fixed capacity: no dynamic resizing.
- Only works with `int` (not generic).
