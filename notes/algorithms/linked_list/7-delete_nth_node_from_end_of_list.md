### Problem

You're given the head of a singly linked list and an integer `n`. Your task is to remove the **nth node from the end** of the list and return the updated head.

[LeetCode 19](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)

Examples:

* `1 → 2 → 3 → 4 → 5`, `n = 2` → remove 4 → `1 → 2 → 3 → 5`
* `1 → 2`, `n = 2` → remove 1 → `2`

---

### Brute Force Approach (Two Passes)

#### Core Idea

To delete the nth node **from the end**, you need to know how many nodes there are. Since a singly linked list doesn’t give you that upfront, you:

1. **Traverse the list once** to count all the nodes.
2. Use that count to calculate the position of the node **from the front**.
3. Traverse again and **stop right before** that node.
4. Change the `.next` pointer to **skip the target node**, thereby deleting it.

#### Step-by-Step

1. Traverse and count:

   * Example: `1 → 2 → 3 → 4 → 5` → count = 5
2. Find index to delete from front:

   * Index = `count - n` → `5 - 2 = 3`
3. Traverse to the 3rd node (`node with value 3`)
4. Skip the next node:

   * `3.next = 3.next.next` → `4` is removed

#### Edge Case

If `n == count`, it means you're deleting the **first** node. Just return `head.next`.

#### Code

```java
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Step 1: Get length of the list
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // Step 2: Handle case where we remove the first node
        if (n == length) {
            return head.next;
        }

        // Step 3: Go to node before the one to delete
        int target = length - n;
        temp = head;
        for (int i = 1; i < target; i++) {
            temp = temp.next;
        }

        // Step 4: Remove the node
        temp.next = temp.next.next;

        return head;
    }
}
```

#### Complexity

* Time: O(n) + O(n) = **O(n)**
* Space: O(1)

### Optimal Approach (One Pass, Two Pointers)

#### Core Idea

We avoid two passes by using **two pointers**. Here's how:

1. Start two pointers: `first` and `second`, both at `head`.
2. Move `first` pointer `n` steps forward.
3. Then move both pointers **at the same time** until `first` reaches the end.
4. At that point, `second` will be **right before the node to delete**.
5. Skip the next node with: `second.next = second.next.next`

#### Why It Works

Moving `first` `n` steps ahead creates a gap of `n` between `first` and `second`. So when `first` hits null (end), `second` is at the perfect spot to delete the nth node from end.

#### Special Case

If `n` is equal to the list length, `first` will become `null` after moving `n` times. That means you need to remove the **first** node. Use a dummy node to handle this smoothly.

#### Code

```java
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Dummy node to handle edge cases like deleting head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        // Step 1: Move first pointer n+1 steps forward
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Step 2: Move both pointers
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Step 3: Delete target node
        second.next = second.next.next;

        return dummy.next;
    }
}
```

#### Complexity

* Time: O(n)
* Space: O(1)
