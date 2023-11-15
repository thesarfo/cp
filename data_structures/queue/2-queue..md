Queue follows the First In First Out (FIFO) rule - the item that goes in first is the item that comes out first.

putting items in the queue is called enqueue, and removing items from the queue is called dequeue.

### Basic Operations of Queue
A queue is an object (an abstract data structure - ADT) that allows the following operations:

Enqueue: Add an element to the end of the queue
Dequeue: Remove an element from the front of the queue
IsEmpty: Check if the queue is empty
IsFull: Check if the queue is full
Peek: Get the value of the front of the queue without removing it

### Working of Queue
Queue operations work as follows:

1. two pointers FRONT and REAR
2. FRONT track the first element of the queue
3. REAR track the last element of the queue
4. initially, set value of FRONT and REAR to -1


### Enqueue Operation
1. check if the queue is full
2. for the first element, set the value of FRONT to 0
3. increase the REAR index by 1
4. add the new element in the position pointed to by REAR

### Dequeue Operation
1. check if the queue is empty
2. return the value pointed by FRONT
3. increase the FRONT index by 1
4. for the last element, reset the values of FRONT and REAR to -1

### Complexity Analysis
The complexity of enqueue and dequeue operations in a queue using an array is O(1). If you use pop(N) in python code, then the complexity might be O(n) depending on the position of the item to be popped.