To delete from the tail of a linked list, we can follow the below steps.

Note that, in order to delete from a linked list, we need to make sure that nothing points to the node we wanna delete. In this case, the node to be deleted is the tail. And so we need to stop at the penultimate node and then make sure that it points to null.

This means that we will stop at the last but one node, and then check if that `node.next.next == null` and then update it to `node.next = null`

Below is a simple code implementation of the logic

```java
public Node removeTail(Node head){
    if(head == null || head.next == null){ // list is empty / contains only 1 element
        return null;
    }

    Node temp = head;

    while(temp.next.next != null){
        temp = temp.next;
    }
    temp.next = null

    return head;
}
```