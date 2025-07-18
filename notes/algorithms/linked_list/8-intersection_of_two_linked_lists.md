### Problem

You're given two singly linked lists. You need to return the **node at which the two lists intersect**. If the lists do not intersect, return `null`.

[LeetCode 160 – Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists/)

Examples:

* A: `4 → 1 → 8 → 4 → 5`
  B: `5 → 6 → 1 → 8 → 4 → 5`
  Output: `8`

* A: `1 → 9 → 1 → 2 → 4`
  B: `3 → 2 → 4`
  Output: `2`

---

### Brute Force Approach (Nested Loops)

#### Core Idea

For every node in list A, scan every node in list B to check if they are the **same by reference** (not value).

#### Step-by-Step

1. Start from the first node of list A.
2. For each node in A, traverse all nodes in B and check if `a == b`.
3. Return the node when found.

#### Code

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while (headA != null) {
            ListNode temp = headB;
            while (temp != null) {
                if (headA == temp)
                    return headA;
                temp = temp.next;
            }
            headA = headA.next;
        }
        return null;
    }
}
```

#### Complexity

* Time: O(m \* n)
* Space: O(1)

---

### Better Approach (Hashing)

#### Core Idea

Store every node from list A in a `HashSet`. Then traverse list B and return the first node that exists in the set.

#### Step-by-Step

1. Create an empty set.
2. Traverse list A and store each node reference.
3. Traverse list B and return the first node that appears in the set.

#### Code

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) return headB;
            headB = headB.next;
        }

        return null;
    }
}
```

#### Complexity

* Time: O(m + n)
* Space: O(m)

---

### Optimal Approach (Two Pointers)

#### Core Idea

Use two pointers to traverse the lists. When one pointer hits the end, switch it to the head of the other list. They will meet at the intersection point.

#### Why It Works

* The first pointer travels `a + c` and then `b` (total `a + c + b`).
* The second pointer travels `b + c` and then `a` (total `b + c + a`).
* Both pointers meet after traversing equal lengths.

#### Step-by-Step

1. Start two pointers at headA and headB.
2. Move each forward one node at a time.
3. When one reaches the end, redirect it to the start of the other list.
4. If the lists intersect, pointers will meet at the intersection. Otherwise, they’ll meet at `null`.

#### Code

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = (a != null) ? a.next : headB;
            b = (b != null) ? b.next : headA;
        }

        return a;
    }
}
```

#### Complexity

* Time: O(m + n)
* Space: O(1)

