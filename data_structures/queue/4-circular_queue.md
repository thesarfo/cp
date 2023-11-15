In a circular queue, the last element points to the first element making a circular link.

The main advantage of a circular queue over a simple queue is better memory utilization. If the last position is full and the first position is empty, we can insert an element in the first position. This action is not possible in a simple queue.

The circular queue solves the major limitation of the normal queue. In a normal queue, after a bit of insertion and deletion, there will be non-usable empty space.

### Circular Queue Operations

1. two pointers FRONT and REAR

2. FRONT track the first element of the queue

3. REAR track the last elements of the queue

4. initially, set value of FRONT and REAR to -1


### Enqueue Operation

1. check if the queue is full

2. for the first element, set value of FRONT to 0

3. circularly increase the REAR index by 1 (i.e. if the rear reaches the end, next it would be at the start of the queue)

4. add the new element in the position pointed to by REAR


### Dequeue Operation

1. check if the queue is empty

2. return the value pointed by FRONT

3. circularly increase the FRONT index by 1

4. for the last element, reset the values of FRONT and REAR to -1


However, the check for full queue has a new additional case:

Case 1: FRONT = 0 && REAR == SIZE - 1
Case 2: FRONT = REAR + 1
The second case happens when REAR starts from 0 due to circular increment and when its value is just 1 less than FRONT, the queue is full.


### Circular Queue Complexity Analysis

The complexity of the enqueue and dequeue operations of a circular queue is O(1) for (array implementations)