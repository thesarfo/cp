## Adding to the head of a linked list
1. Node Creation: Create a new node with the given data.
2. Store Current Head: Keep a reference to the current head of the list.
3. Update Head: Set the new node as the new head of the list.
4. Link Nodes: If the list was not empty (the current head is not null), link the new head node to the previous head node.
```java
function addToHead(data):
    newHead = new Node(data)         // Create a new node with the given data
    currentHead = head               // Store the current head of the list
    head = newHead                   // Set the new node as the head of the list
    if currentHead is not null:      // If the list was not empty
        head.setNextNode(currentHead) // Link the new head to the previous head
```

## Adding to the tail of a linked list
1. Initialization: Start with the head of the list.
2. Empty List Check: If the list is empty, create a new node and set it as the head.
3. Traversal: If the list is not empty, traverse to the last node.
4. Addition: Create a new node and add it as the next node of the current last node
```java
function addToTail(data):
    tail = head                    // initialize a variable tail to the head
    if tail is null:                  // Check if the list is empty
        head = new Node(data)         // Create a new node as the head
    else:
        while tail.getNextNode() is not null:
            tail = tail.getNextNode() // Traverse to the last node
        tail.setNextNode(new Node(data)) // Add the new node at the end
```

## Removing the head of a linked list
1. Store Reference to Current Head: Keep a reference to the current head of the list.
2. Check for Empty List: If the list is empty (current head is null), return null as there's no head to remove.
3. Update Head: Set the head of the list to the next node after the current head.
4. Return Removed Node's Data: Return the data of the removed head node.
```java
function removeHead():
    currentHead = head                  // Store a reference to the current head node
    if currentHead is null:             // If the list is empty
        return null                     // Return null as there's no head to remove
    head = currentHead.getNextNode()    // Update the head to the next node
    return currentHead.getData()        // Return the data of the removed head node
```

### Traversing a Linked List
```java
class Node<TreeNode>{
    TreeNode data;
    Node next;

    Node(TreeNode data){
        this.data = data;
    }

    void traverse(Node head){
        Node curr = head;

        while (curr != null){
            print(curr.data);
            curr = curr.next;
        }
    }

    // using the traverse function
    void main(){
        traverse(head);
    }
}
```

### Deleting a node from a linked list
1. check if the node to be deleted is the head
2. traverse to the node before the target position
3. remove the target node
```java
void main(){
    delete(head, 3);
}

void delete(Node head, int pos){
    if (pos == 0){
        head = head.next;
        return;
    }
    Node currentNode = head;

    for (int i = 0; i < pos - 1; i++){
        currentNode = currentNode.next;
    }
    currentNode.next = currentNode.next.next;
}
```


### Removing all occurences of a value from a linked list
1. skip all nodes at the beginning of the list that have the value of k
2. if after the loop l is null, it means that the list was entirely composed of nodes with the value k, so you return null.
3. we traverse through the list, and if the next value of the current node is not null, check if the next value is equal to k. remove the next value if it is equal to k, else, update the current nodes next pointer the next node

```java
ListNode<Integer> solution(ListNode<Integer> l, int k) {
    while (l != null && l.value == k) {
        l = l.next;
    }
    
    if (l == null) {
        return null;
    }
    
    ListNode<Integer> current = l;
    while (current.next != null) {
        if (current.next.value == k) {
            current.next = current.next.next;
        } else {
            current = current.next;
        }
    }
    
    return l;
}
```

# Rob Edwards 

## Boundary Conditions - things you should consider when working with data structures

1. Empty Data Structure
2. Single element in the data structure
3. Adding / Removing from the beginning of the data structure
4. Adding / Removing from the end of the data structure
5. Working in the middle of the data structure


### Adding to the first/head of a linked list
1. create a new node
2. make node.next point to the same node that the head is pointing to
3. make our head point to our new node
```java
public void addFirst(E obj){
    Node<E> node = new Node<E>(obj);
    node.next = head;

    head = node;
    currentSize++; //keep track of the size of the linked list by incrementing or decrementing the size


}
```

### Adding to the end of a linked list
1. we introduce a dummy/temp node which points to the head of the linked list.
2. we know the temp node is not the last node, if its `.next` is not null, i.e it points to another node.
3. so we basically initialize a loop that, while the `.next` of the temp node is not null, we want to make temp point to the next node.
4. If we get to a point where `temp.next` is null, we know that we have gotten to the end of the list.
5. we can then make the last node, point to our new node
```java
public void addLast(E obj){
    Node<E> temp = head;
    Node<E> newNode = new Node<E>(obj);

    while(temp.next != null){
        temp = temp.next;
    }
    temp.next = newNode;
}
```
6. in the case where the list is empty, head points to null. therefore we will get a null pointer exception if we try to access temp.next
7. So, we first need to check, if the list is empty, and then if it is, make our head point to our new node.
```java
public void addLast(E obj){
    if (head == null){
        head = newNode;
        currentSize++;
        return;
    }
    Node<E> temp = head;
    Node<E> newNode = new Node<E>(obj);

    while(temp.next != null){
        temp = temp.next;
    }
    temp.next = newNode;
}
```

The above implementation is linear 0(n). the loop runs for the number of times as the number of elements in the list. To optimize this solution, perhaps we can use the currentSize variable to our advantage. What if we had a pointer called `tail` that points to the last element of our list. And whenever we want to update the last element of the linked list we just call `tail.next`. That is completely doable
```java
public void addLast(E obj){
    Node<E> newNode = new Node<E> (obj);
    if (head == null){
        head = tail = node;
        currentSize++;
        return;
    }

    tail.next = newNode;
    tail = newNode;
    currentSize++;
    return;

}
```


### Removing from the head/first node of a linked list (and return the data in the removed node)
1. We know a node is our first node if the head points to it.
2. to remove our first node, we simply make head point to the second node. therefore making the first node garbage collected. `head = head.next`
3. But in the case of an empty list, the head points to null, because the list is empty. Therefore making `head = head.next` will simply lead to a null pointer exception.
```java
public E removeFirst(){
    if (head == null){
        return null;
    }

}
```
4. But in the case the list isn't empty, we need to remember what the data of that node is. so we need to store that in a temporary variable. 


```java
public E removeFirst(){
    if (head == null){
        return null;
    }
    E temp = head.data;

}
```

5. In the case where there is just one element in the list, we need to update both the head and tail pointers in the list.
```java
public E removeFirst(){
    if (head == null){
        return null;
    }
    E temp = head.data;

    if (head == tail){
        head = tail = null;
    } else{
        head = head.next;
    }
    currentSize--;

    return temp;

}
```

### Removing from the tail/last node of a linked list
Certainly, we can just update the tail pointer to point to the second last node in the linked list. But in a singly linked list, there is no way to actually move from the tail backwards. So we have to start from the front of the list.

How do we go about this, we introduce two dummy variables/pointers. `previous` and `current`. Before we start iterating through the list, `previous` points to null, and `current` points to the head of the list. Now as we start iterating, we will move `current` to `current.next` and `previous` to where `current` used to be. We do that until we get to the end of the list. We know we have gotten to the end of the list when `current.next` is equal to null, or `current.next` is equal to `tail`. This means that `previous` is right before `current`. So all we have to do is to just make `previous.next` equal to null. that will delete the last element in the list.

```java
public E removeLast(){
    if (head == null){
        return null;
    }

    // single element
    if (head == tail){
        return removeFirst();
    }

    Node<E> current = head;
    Node<E> previous = null;

    while(current.next != null){
        previous = current;
        current = current.next;
    }
    previous.next = null;
    tail = previous;
    currentSize++;
    return current.data;

}
```