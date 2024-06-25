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

