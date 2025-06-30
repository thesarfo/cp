### Problem: Reverse a Singly Linked List

Given the `head` of a singly linked list, reverse the list and return the new head.

For example:

* Input: `1 → 2 → 3 → 4 → 5`
* Output: `5 → 4 → 3 → 2 → 1`

[Leetcode 206](https://leetcode.com/problems/reverse-linked-list/)

We will explore **two different approaches**:

1. A **brute force** method using a stack (extra space)
2. An **optimal** method that reverses the list in place (no extra space)

### Brute Force Approach – Use a Stack

### Why this works:

A stack is **Last-In-First-Out (LIFO)**.
By pushing values from the list into the stack and popping them out, we get the values in reverse order.
Then we just **overwrite** each node’s value with the reversed ones.

### Steps:

#### 1. Traverse the list and store values in a stack:

* We go through the list from head to tail.
* For every node, we `push` its `val` into a stack.

#### 2. Reset pointer and overwrite node values:

* After collecting all values, we reset a pointer to `head`.
* We then pop values from the stack and assign them back to each node's `val`.

This reverses the *data*, not the links.



### Example:

Given `1 → 2 → 3 → 4`
Stack after first loop: `[1, 2, 3, 4]`
Overwriting:

* node1 gets `4`,
* node2 gets `3`,
* node3 gets `2`,
* node4 gets `1`
  Final list: `4 → 3 → 2 → 1`

Below is a code implementation in Java

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode current = head;
        Stack<Integer> stack = new Stack<>();

        // Step 1: Push values into stack
        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }

        current = head;

        // Step 2: Overwrite node values in reverse
        while (current != null) {
            current.val = stack.pop();
            current = current.next;
        }

        return head;
    }
}
```


### Time and Space Complexity

* **Time**: `O(n)` – We go through the list twice.
* **Space**: `O(n)` – We store all values in the stack.


### Optimal Approach – Reverse In-Place (No Extra Space)

### Why this works:

Instead of reversing the values, we reverse the **links** (the `next` pointers).
We do this while traversing, so it only uses constant space.

### Pointers Used:

* `cur` → current node we're working on
* `prev` → node that comes before `cur` (starts as `null`)
* `front` → temporary variable to store `cur.next` before we overwrite it

### Steps:

#### 1. Initialize `prev` to `null`, and `cur` to `head`.

#### 2. Iterate over the list:

* Store the next node using `front = cur.next`
* Reverse the pointer: `cur.next = prev`
* Move `prev` and `cur` forward

When `cur` becomes `null`, `prev` will be pointing to the new head of the reversed list.


### Example:

Original: `1 → 2 → 3 → 4 → 5`

Let's walk through just the first couple steps:

* Initial:

  * `prev = null`
  * `cur = 1`

* First Iteration:

  * `front = 2`
  * `cur.next = null`
  * Move `prev = 1`, `cur = 2`

* Second Iteration:

  * `front = 3`
  * `cur.next = 1`
  * Move `prev = 2`, `cur = 3`

Eventually, you'll get: `5 → 4 → 3 → 2 → 1`

Below is a code implementation in Java

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode front = cur.next; // Save next node
            cur.next = prev;           // Reverse current node's pointer
            prev = cur;                // Move prev forward
            cur = front;               // Move cur forward
        }

        return prev; // New head of the reversed list
    }
}
```


### Time and Space Complexity

* **Time**: `O(n)` – Every node is visited once.
* **Space**: `O(1)` – No extra memory is used.
