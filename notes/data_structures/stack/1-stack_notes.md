A stack is a linear data structure that follows the principle of Last In First Out (LIFO). This means the last element inserted inside the stack is removed first.


### Stack operations

Push: Add an element to the top of a stack
Pop: Remove an element from the top of a stack
IsEmpty: Check if the stack is empty
IsFull: Check if the stack is full
Peek: Get the value of the top element without removing it

### Working of Stack Data Structure

1. A pointer called TOP is used to keep track of the top element in the stack.

2. When initializing the stack, we set the TOP value to -1 so that we can check if the stack is empty by comparing TOP == -1.

3. On pushing an element, we increase the value of TOP and place the new element in the position pointed to by TOP.

4. On popping an element, we return the element pointed to by TOP and reduce its value.

5. Before pushing, we check if the stack is already full

6. Before popping, we check if the stack is already empty


For the array-based implementation of a stack, the push and pop operations take constant time, i.e. O(1).