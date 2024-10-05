A special type of queue in which each element is associated with a priority value and is served according to its priority. If elements with the same priority occur, they are served according to their order in the queue.

Insertion occurs based on the arrival of the values and removal occurs based on priority.

### Assigning Priority Value

Generally, the value of the element itself is considered for assigning the priority. For example,

The element with the highest value is considered the highest priority element. However, in other cases, we can assume the element with the lowest value as the highest priority element.

We can also set priorities according to our needs.

### Difference between Priority Queue and Normal Queue

In a queue, the first-in-first-out rule is implemented whereas, in a priority queue, the values are removed on the basis of priority. The element with the highest priority is removed first.

### Implementation of Priority Queue

Priority queue can be implemented using an array, a linked list, a heap data structure, or a binary search tree. But the heap data structure provides an efficient implementation of priority queues.

### Priority Queue Operations

Basic operations of a priority queue are inserting, removing, and peeking elements. (I have to read on Heap Data structure to better understand the binary heap used to implement the priority queue below)

#### Inserting an Element into the Priority Queue

1. Insert the new element at the end of the tree

2. Heapify the tree

Algorithm for insertion of an element into priority queue (max-heap)

```text
If there is no node, 
  create a newNode.
else (a node is already present)
  insert the newNode at the end (last node from left to right.)
  
heapify the array
```

For Min Heap, the above algorithm is modified so that parentNode is always smaller than newNode.

#### Deleting an Element from the Priority Queue

1. Select the element to be deleted.

2. Swap it with the last element.

3. Remove the last element.

4. Heapify the tree.

Algorithm for deletion of an element in the priority queue (max-heap)

```text
If nodeToBeDeleted is the leafNode
  remove the node
Else swap nodeToBeDeleted with the lastLeafNode
  remove noteToBeDeleted
   
heapify the array
```

For Min Heap, the above algorithm is modified so that the both childNodes are smaller than currentNode.

#### Peeking from the Priority Queue (Find max/min)
Peek operation returns the maximum element from Max Heap or minimum element from Min Heap without deleting the node.

For both Max heap and Min Heap

```python 
return rootNode
```

#### Extract-Max/Min from the Priority Queue

Extract-Max returns the node with maximum value after removing it from a Max Heap whereas Extract-Min returns the node with minimum value after removing it from Min Heap.

### Priority Queue Applications
Some of the applications of a priority queue are:

1. Dijkstra's algorithm
2. for implementing stack
3. for load balancing and interrupt handling in an operating system
4. for data compression in Huffman code