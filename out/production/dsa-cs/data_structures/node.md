# Nodes

In python, you have a list, and inside the list you have elements that go on and on till you reach the last element of that list.

```python
a = [ 1, 2, 3, 4, 5]
```

The idea is that at every location in the list, you have a value, and there's always a value that follows it until you reach the last element.

So, when dealing with such data structures, we typically use the concept of a "Node" to track them.

A node is a fundamental data structure, that holds two pieces of information - the value of the current node, and a pointer to the next value that follows it. Below is how a node is implemented.

```python
class Node:
    def __init__(self, value, next):
        self.value = value
        self.next = next

    # these are getters and setters for the values and next
    def getValue(self):
        return self.value
    
    def getNext(self):
        return self.next
    
    def setValue(self.value):
        self.value = value
    
    def setNext(self.next):
        self.next = next
    
    #we can create objects of the Node class
first = Node(3, None) # None means it points to nothing
second = Node(4, first) # This one has a pointer to first

# In list terms, the 'first' and 'second' will look like this
[ 4, 3 ]
```
