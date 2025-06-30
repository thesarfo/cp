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

## 🔁 Reversing the List

### Problem

Given the head of a doubly linked list, **reverse the list in-place** so that the head becomes the tail and vice versa.

### Explanation

1. If the list is empty or has only one node, it’s already reversed — return the same head.
2. Initialize a pointer `current` to the head and `prev` to `null`.
3. Traverse the list:

   * For each node, swap the `next` and `prev` pointers.
   * Move `current` forward by following the **new** `prev` pointer (which was originally `next`).
4. After traversal, the `prev` pointer holds the previous node of the old head.

   * Its `prev` field (which used to be the next of the last node) points to the new head.
5. Return `prev.prev` as the new head.

### Code

```java
public Node reverse(Node head) {
    if (head == null || head.next == null) return head;

    Node current = head;
    Node prev = null;

    while (current != null) {
        // Store original prev
        prev = current.prev;

        // Swap next and prev pointers
        current.prev = current.next;
        current.next = prev;

        // Move to the next node (which is current.prev after the swap)
        current = current.prev;
    }

    // After the loop, prev holds the last node we visited
    // Its prev is the new head
    return prev.prev;
}
```

## 🧱 Reversing the List (Brute-Force)

### Problem

Given the head of a doubly linked list, reverse it **without modifying the links**, by only changing the data values.

### Explanation

1. If the list is empty or has only one node, it's already reversed — return the same head.
2. Initialize a pointer `current` to the head and a `Stack<Integer>` to store the values.
3. Traverse the list once, pushing all node `data` values into the stack.
4. Re-initialize `current` to the head.
5. Traverse again, and for each node:

   * Pop the top value from the stack.
   * Assign it to `current.data`.
6. Return the head (the structure is unchanged, but data values are reversed).

### Code

```java
public Node reverseBruteForce(Node head) {
    if (head == null || head.next == null) return head;

    Stack<Integer> stack = new Stack<>();
    Node current = head;

    // First pass: push all data into the stack
    while (current != null) {
        stack.push(current.data);
        current = current.next;
    }

    // Second pass: replace node data with values from the stack
    current = head;
    while (current != null) {
        current.data = stack.pop();
        current = current.next;
    }

    return head;
}
```