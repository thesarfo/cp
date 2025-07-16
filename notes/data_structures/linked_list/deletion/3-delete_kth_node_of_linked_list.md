There are multiple scenarios we need to consider in this scenario. We are given a linked list and our task is to delete the `kth` node.

* what if `k` is greater than the linked list length
* what if `k` is the first node in the linked list = head
* what if `k` is the last node in the linked list = tail
* what if `k` is neither of the above = middle nodes

So, we need to come up with an algo that puts all the above scenarios into consideration


below is a code implementation
```java
public Node deleteKthNode(Node head, int k){
    if(head == null) return head; // if the LL is empty

    if(k == 1){ // delete head of the LL
        head = head.next;
        return head;
    }

    Node temp = head;
    int count = 1;

    // Move to the (k-1)th node
    while(temp != null && count < k - 1){
        temp = temp.next;
        count++;
    }

    // If k is greater than the length of the list
    if(temp == null || temp.next == null){
        return head; // Do nothing, invalid k
    }

    // Skip the kth node
    temp.next = temp.next.next;

    return head;
}


```