### Problem

You're given the head of a singly linked list and asked to group all the nodes with odd indices together followed by the nodes with even indices. The relative order of nodes within the groups should remain the same.

[LeetCode 328](https://leetcode.com/problems/odd-even-linked-list/)

---

### Brute Force Approach (Using Extra Space)

### Core Idea

Store all the odd-indexed values first, then all the even-indexed values in a list, and reassign them back to the linked list.

We need two passes:

1. Go through odd index nodes (`0, 2, 4...`) and collect values.
2. Go through even index nodes (`1, 3, 5...`) and collect values.
3. Reassign the collected values back to the original list.

This works but uses extra space and doesn't take advantage of the linked list structure.

### Complexity

* Time: O(n)
* Space: O(n)

### Code

```java
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        List<Integer> ll = new ArrayList<>();
        ListNode temp = head;

        while (temp != null && temp.next != null) {
            ll.add(temp.val);
            temp = temp.next.next;
        }
        if (temp != null) ll.add(temp.val); // for odd length lists, temp will be at the last node

        temp = head.next;

        while (temp != null && temp.next != null) {
            ll.add(temp.val);
            temp = temp.next.next;
        }
        if (temp != null) ll.add(temp.val); // for even length lists, temp will be at the last node

        temp = head;
        int idx = 0;

        while (temp != null) {
            temp.val = ll.get(idx);
            idx++;
            temp = temp.next;
        }

        return head;
    }
}
```

---

### Optimal Solution (In-Place Reordering)

### Core Idea

We use two pointers:

* `odd` to track the end of the odd-indexed list.
* `even` to track the end of the even-indexed list.
  We also store the `evenHead` so we can append it after the odd list is done.

Steps:

1. Traverse and rearrange the next pointers: odd nodes point to the next odd, even to the next even.
2. After the loop, connect the tail of the odd list to the head of the even list (`odd.next = evenHead`).

This keeps the rearrangement in-place and preserves order within each group.

### Complexity

* Time: O(n)
* Space: O(1)

### Code

```java
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }
}
```
