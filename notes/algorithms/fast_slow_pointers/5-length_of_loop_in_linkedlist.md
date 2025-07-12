### Problem Statement

Given the head of a singly linked list, determine the **length of the loop**, if one exists. If there is no loop, return `0`.


## 1. Brute Force Approach — Using HashMap

**Idea**:
Track every visited node along with a "timer" or step count.
If a node is revisited, the difference in step count between the first and second visits is the length of the cycle.

**Steps**:

1. Traverse the list using a pointer.
2. For each node, store the current step number in a `HashMap<Node, Integer>`.
3. If a node is visited again, calculate the difference between the current timer and the previous timer → this is the length of the loop.
4. If the list ends (`null`), there is no cycle.

**Time Complexity**: O(n)
**Space Complexity**: O(n) — due to the hash map

**Java Code**:

```java
public static int lengthOfLoop(Node head) {
    Map<Node, Integer> visited = new HashMap<>();
    Node current = head;
    int timer = 0;

    while (current != null) {
        if (visited.containsKey(current)) {
            return timer - visited.get(current);
        }
        visited.put(current, timer);
        current = current.next;
        timer++;
    }

    return 0; // No loop
}
```

## 2. Optimal Approach — Floyd’s Tortoise and Hare + Loop Length Count

**Idea**:
Detect a cycle using Floyd’s algorithm (two-pointer technique).
Once a cycle is found (i.e., `slow == fast`), keep one pointer fixed and move the other one step at a time until it loops back to the same node. Count the steps during this traversal — that's the loop length.

**Steps**:

1. Initialize two pointers: `slow` and `fast`, both starting at `head`.
2. Move `slow` by 1 and `fast` by 2 steps until they meet (cycle detected).
3. Once they meet, fix one pointer and start counting steps by moving the other one step at a time until they meet again.
4. Return the step count as the length of the cycle.

**Time Complexity**: O(n)
**Space Complexity**: O(1)

**Java Code**:

```java
static int lengthOfLoop(Node head) {
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast) {
            return countLoopLength(slow);
        }
    }

    return 0; // No loop
}

static int countLoopLength(Node meetingPoint) {
    Node current = meetingPoint.next;
    int length = 1;

    while (current != meetingPoint) {
        current = current.next;
        length++;
    }

    return length;
}
```

**Why It Works**:
If two pointers meet inside a loop, it means there is a cycle. From any point inside a cycle, traversing the loop will return to the same node after `k` steps — where `k` is the loop length.