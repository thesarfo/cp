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

This is how a simple node can be implemented in java
```java
public class Node {
  	public String data;
    public Node next;

    public Node(String data){ // set the data and next values in the constructor
      this.data = data;
      this.next = null;
    }

	public static void main(String[] args) {
    Node firstNode = new Node("I am a Node!");
    System.out.println(firstNode.data);
    System.out.println(firstNode.next);
	}
}
```

Currently, when a Node is created, its next Node is set to null. However, we want to allow the next property to be updated so a sequence of nodes can be traversed and used in more complex data structures. For this, we will create a setter method to modify the this.next property.

The method will be called .setNextNode() and take a Node as an argument, updating the next property appropriately.
```java
public class Node {

  public String data;
  public Node next;	

  public Node(String data) {
    this.data = data;
    this.next = null;
  }

  public void setNextNode(Node node){
    this.next = node;
  }

  public static void main(String[] args) {
    Node firstNode = new Node("I am a Node!");
    Node secondNode = new Node("I am the second Node!");

    firstNode.setNextNode(secondNode);
    System.out.println(firstNode.next.data);
  }

}
```

### Getting the Next Node
While we could continue accessing the next node property directly it’s safer to have important variables only accessible through methods.
Let’s go ahead and create a simple .getNextNode() method that will return the next node property.
```java
public class Node {

  public String data;
  private Node next;	

  public Node(String data) {
    this.data = data;
    this.next = null;
  }

  public void setNextNode(Node node) {
    this.next = node;
  }

  public Node getNextNode() {
    return this.next;
  }

  public static void main(String[] args) {
    Node firstNode = new Node("I am the first Node!");
    Node secondNode = new Node("I am the second Node!");
    firstNode.setNextNode(secondNode);
    System.out.println(firstNode.getNextNode().data);
  }
}
```