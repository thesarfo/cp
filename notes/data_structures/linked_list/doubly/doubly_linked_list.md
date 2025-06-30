A **doubly linked list node** contains:

* An integer `data`
* A `next` pointer to the next node
* A `prev` pointer to the previous node

```java
class Node {
    public int data;
    public Node next;
    public Node prev;

    // Full constructor
    public Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    // Constructor for creating a standalone node (e.g., the last or only node)
    public Node(int data) {
        this(data, null, null);
    }
}
```

### ✅ LinkedList Class (Skeleton)

```java
public class LinkedList {
    // Implementation will be built around this structure
}
```

---

## 🔼 Inserting Before the Head

### Problem

Given the head of a doubly linked list and a value, insert a new node *before* the current head. The new node should become the new head of the list.

### Explanation

1. Create a new node with the given value.
2. Set its `next` to point to the current head.
3. Update the `prev` of the current head to point to the new node.
4. Return the new node as the new head.

### Code

```java
public Node insertBeforeHead(Node head, int val) {
    Node newHead = new Node(val, head, null);
    if (head != null) {
        head.prev = newHead;
    }
    return newHead;
}
```

---

## 🔽 Inserting Before the Tail

### Problem

Given the head of a doubly linked list, insert a new node *just before the tail*.

### Explanation

1. Traverse the list to find the tail (i.e., last node).
2. Identify the penultimate node (i.e., `tail.prev`).
3. Create a new node:

   * Set its `next` to point to the tail.
   * Set its `prev` to point to the penultimate node.
4. Update the tail's `prev` and the penultimate node's `next` to link to the new node.

### Code

```java
public Node insertBeforeTail(Node head, int val) {
    if (head == null || head.next == null) {
        // List is empty or has only one node; inserting before tail is same as inserting before head
        return insertBeforeHead(head, val);
    }

    Node current = head;
    while (current.next != null) {
        current = current.next;
    }

    Node tail = current;
    Node penultimate = tail.prev;

    Node newNode = new Node(val, tail, penultimate);
    penultimate.next = newNode;
    tail.prev = newNode;

    return head;
}
```


## ❌ Deleting the Last Node

### Problem

Given the head of a doubly linked list, **delete the last node** (i.e., the tail).

### Explanation

1. If the list is empty (`head == null`), return `null`.
2. If the list contains only one node, deleting it makes the list empty → return `null`.
3. Traverse the list to find the last node (`tail`).
4. Identify the second-last node (`tail.prev`).
5. Set the second-last node's `next` to `null`, effectively removing the tail.
6. Disconnect `tail.prev` to break backward reference.
7. Return the `head` (which may or may not have changed).

### Code

```java
public Node deleteTail(Node head) {
    if (head == null) return null; // Empty list
    if (head.next == null) return null; // Only one node

    Node current = head;
    while (current.next != null) {
        current = current.next;
    }

    Node tail = current;
    Node penultimate = tail.prev;

    penultimate.next = null;
    tail.prev = null; // Optional: helps with garbage collection

    return head;
}
```