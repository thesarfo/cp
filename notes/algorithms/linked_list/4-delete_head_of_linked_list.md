To delete the head of the linked list, you can follow a straightforward approach simply by updating the next pointer of the current head.

Below is a simple implementation
```java
public Node deleteHead(Node head){
    Node temp = head;
    head = head.next; // head now starts at the 2nd val in the linkedlist
    return head;
}
```
NB: in c++ you'll have to call `free(temp)` to remove the temp var before returning. In java the GC automatically frees it.

**Covering some edge cases**
```java
public Node deleteHead(Node head){
    if(head == null) return null; // empty list
    head = head.next; 

    return head;
}
```