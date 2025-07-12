### Problem Summary

Given the head of a singly linked list, determine if the linked list contains a cycle.

A cycle occurs if some node in the list can be reached again by continuously following the `next` pointer.

You only need to detect **whether a cycle exists**, not find where it starts (unlike Problem 142).

[Leetcode 141](https://leetcode.com/problems/linked-list-cycle)


### Approach 1: HashSet (Tracking Visited Nodes)

**Idea**:
Traverse the list while storing each visited node in a HashSet.
If a node is revisited, there is a cycle.

**Algorithm**:

1. Initialize an empty `HashSet`.
2. Iterate through the list.
3. For each node, check if it is already in the set:

   * If yes, return `true` (cycle detected).
   * If no, add it to the set and move forward.
4. If the end of the list is reached (`null`), return `false`.

**Time Complexity**: O(n)
**Space Complexity**: O(n)

**Java Code**:

```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode current = head;

        while (current != null) {
            if (visited.contains(current)) {
                return true;
            }
            visited.add(current);
            current = current.next;
        }

        return false;
    }
}
```

**Cons**:

* Uses extra memory proportional to list length.

---

### Approach 2: Floyd’s Tortoise and Hare (Two-Pointer Method)

**Idea**:
Use two pointers, `slow` and `fast`.
`slow` moves one step at a time, `fast` moves two steps.
If the list contains a cycle, they will eventually meet.

**Algorithm**:

1. Initialize both `slow` and `fast` at the head.
2. While `fast` and `fast.next` are not null:

   * Move `slow` by one node.
   * Move `fast` by two nodes.
   * If `slow == fast`, a cycle is detected → return `true`.
3. If the end of the list is reached, return `false`.

**Time Complexity**: O(n)
**Space Complexity**: O(1)

**Java Code**:

```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
```

**Why This Works**:
If there's a cycle, the faster-moving pointer will eventually "lap" the slower one inside the loop, causing them to meet.