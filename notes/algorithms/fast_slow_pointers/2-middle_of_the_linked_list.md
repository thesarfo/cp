
## Problem

Given the head of a singly linked list, return the **middle node**.

* If the number of nodes is **odd**, return the actual middle.
* If the number of nodes is **even**, return the **second middle** node.

[Leetcode 876](https://leetcode.com/problems/middle-of-the-linked-list/description/)

---

### Brute Force Approach

### Intuition:

1. Traverse the entire list to **count** how many nodes exist.
2. Compute `middle = count / 2` (second middle if even).
3. Traverse again up to the `middle` index and return that node.

### Steps:

1. Initialize `temp = head`, `count = 0`.
2. Traverse and count nodes (`while temp != null`).
3. Set `mid = count / 2`.
4. Reset `temp = head`, and move `mid` times (`for (i = 0; i < mid; i++) temp = temp.next`).
5. Return `temp`.

### Example:

For list `[1, 2, 3, 4, 5]`, count = 5 → mid = 2 → return 3rd node (`val = 3`).

For list `[1, 2, 3, 4, 5, 6]`, count = 6 → mid = 3 → return 4th node (`val = 4`).

Below is a code implementation

```java
class Solution {
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode temp = head;
        
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        int mid = count / 2;
        temp = head;
        for (int i = 0; i < mid; i++) {
            temp = temp.next;
        }

        return temp;
    }
}
```

### Optimal Approach (Tortoise and Hare)

### Intuition:

Use **two pointers**:

* `slow` moves one step at a time.
* `fast` moves two steps at a time.

When `fast` reaches the end, `slow` will be at the **middle**.

### Steps:

1. Initialize `slow = head`, `fast = head`.
2. Traverse while `(fast != null && fast.next != null)`:

   * `slow = slow.next`
   * `fast = fast.next.next`
3. When the loop ends, return `slow`.

###  How It Works:

* For odd-length list: `fast` reaches the last node → `slow` is at middle.
* For even-length list: `fast` becomes `null` → `slow` is at second middle.

Below is a code implementation

```java
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
```
* Only one pass through the list
* No extra space
