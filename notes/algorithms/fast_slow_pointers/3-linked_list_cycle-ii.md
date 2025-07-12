### Problem Summary

You're given the head of a singly linked list. If there is a cycle in the list, return the node where the cycle begins. If there is no cycle, return `null`.

The goal is to identify the start of the loop, **not just detect whether a loop exists**.

[Leetcode 142](https://leetcode.com/problems/linked-list-cycle-ii)

### Approach 1: HashMap (Brute Force with Extra Space)

**Idea**:
Use a HashMap or HashSet to keep track of nodes you’ve already visited.
If a node appears again during traversal, it must be the start of the cycle.

**Algorithm**:

1. Traverse the list from the head.
2. For each node, check if it already exists in the map.
3. If it does, return that node (start of the cycle).
4. If not, add the node to the map and continue.
5. If the traversal ends (`null`), return `null` – no cycle.

**Time Complexity**: O(n)
**Space Complexity**: O(n)

**Java Code**:

```java
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Map<ListNode, Boolean> visited = new HashMap<>();
        ListNode current = head;

        while (current != null) {
            if (visited.containsKey(current)) {
                return current;
            }
            visited.put(current, true);
            current = current.next;
        }

        return null;
    }
}
```

* Requires O(n) extra memory, which is not optimal.


### Approach 2: Floyd’s Tortoise and Hare (Two-Pointer, Constant Space)

**Idea**:
Use two pointers moving at different speeds to detect a cycle (Floyd’s Algorithm).
If a cycle is detected, reset one pointer to the head and move both pointers one step at a time.
The node where they meet again is the start of the cycle.

**Algorithm**:

1. Initialize two pointers: slow and fast, both at the head.
2. Move `slow` by 1 step, `fast` by 2 steps.
3. If they meet, a cycle exists.
4. Reset one pointer to the head and move both by 1 step.
5. The node where they meet again is the start of the cycle.
6. If fast reaches null, return null (no cycle).

**Time Complexity**: O(n)
**Space Complexity**: O(1)

**Java Code**:

```java
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                ListNode entry = head;
                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry;
            }
        }

        return null;
    }
}
```

**Why This Works**:
When `slow` and `fast` meet inside the loop, the distance from head to the start of the loop equals the distance from the meeting point to the start of the loop if you continue moving in the loop.