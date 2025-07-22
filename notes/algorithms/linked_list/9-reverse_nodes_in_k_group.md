**Problem Summary**:
You are given the `head` of a singly linked list and an integer `k`.
Reverse the nodes of the list **k at a time** and return the modified list.

* If the number of nodes is **not a multiple of k**, leave the last group of nodes as-is.
* You **must reverse the nodes in-place** without modifying the node values.

[LeetCode 25 – Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/)

---

## Examples

### Example 1:

```
Input:  head = [1, 2, 3, 4, 5], k = 2
Output: [2, 1, 4, 3, 5]
```

### Example 2:

```
Input:  head = [1, 2, 3, 4, 5], k = 3
Output: [3, 2, 1, 4, 5]
```

---

## Solution

We’ll break the logic into **3 simple parts**:

1. **Find the kth node** from the current position
2. **Reverse the group** from current to kth
3. **Connect it back** to the list and continue

We use helper methods to keep the code **modular and easy to follow**.

---

Below is a code implementation
```java
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Handle edge cases
        if (head == null || k == 1) return head;

        // Pointers to track current node and previous group's tail
        ListNode temp = head;
        ListNode prevGroupTail = null;

        // New head after the first reversal
        ListNode newHead = null;

        // Traverse the entire list
        while (temp != null) {
            // Step 1: Find the kth node from current temp
            ListNode kth = getKthNode(temp, k);
            if (kth == null) {
                // Less than k nodes left, connect the last group if needed
                if (prevGroupTail != null) {
                    prevGroupTail.next = temp;
                }
                break;
            }

            // Store the next group's starting node
            ListNode nextGroupHead = kth.next;

            // Step 2: Detach and reverse the current group
            kth.next = null;
            ListNode reversedGroupHead = reverseList(temp);

            // Step 3: Connect previous group to current reversed group
            if (prevGroupTail != null) {
                prevGroupTail.next = reversedGroupHead;
            } else {
                newHead = reversedGroupHead; // Set new head on first reversal
            }

            // Move prevGroupTail to current group's tail (which is temp now)
            prevGroupTail = temp;

            // Move temp to the start of the next group
            temp = nextGroupHead;
        }

        // In case we never reversed anything (i.e., total nodes < k)
        return newHead != null ? newHead : head;
    }

    // Helper to get the kth node from current
    private ListNode getKthNode(ListNode node, int k) {
        while (node != null && k > 1) {
            node = node.next;
            k--;
        }
        return node;
    }

    // Helper to reverse a linked list (standard 3-pointer method)
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }

        return prev;
    }
}
```

---

## Step-by-Step Walkthrough

1. **Traverse the list** using a pointer `temp`.
2. For each group:

   * Find the **kth node** ahead using `getKthNode`.
   * If there are **fewer than k nodes**, do not reverse.
   * **Detach the group**, reverse it using `reverseList`.
   * Connect the previous group’s tail to the new reversed group.
3. Repeat until the end of the list.

## Complexity

* **Time Complexity**: O(n)
  Each node is visited once during traversal and once during reversal.

* **Space Complexity**: O(1)
  No extra data structures used; reversal is done in-place.