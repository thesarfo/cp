### Problem?

You're given the head of a singly linked list and asked to check if it’s a palindrome. A list is a palindrome if the values read the same forward and backward.

[LeetCode 234](https://leetcode.com/problems/palindrome-linked-list/)


Think of inputs like:

* `1 → 2 → 2 → 1` → ✅ true
* `1 → 2 → 3 → 2 → 1` → ✅ true
* `1 → 2 → 3` → ❌ false

---

### Brute Force Approach (Using a Stack)

### Core Idea

This approach is simple and relies on reversing the list *logically* using a stack. You first go through the list and **push all the values into a stack**. Since stacks are Last-In-First-Out, popping values from the stack gives you the list in reverse order.

Then, you go through the list again from the head and compare each node’s value with what’s popped from the stack. If everything matches, it’s a palindrome.

### Complexity

* Time: O(n)
* Space: O(n), because we store all node values in the stack

### Code

```java
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;

        // Push all values to the stack
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        // Compare values while popping
        temp = head;
        while (temp != null) {
            if (temp.val != stack.pop()) {
                return false;
            }
            temp = temp.next;
        }

        return true;
    }
}
```

This method is super readable and easy to write, but not space-efficient. Still, it’s a good first solution and shows clear intent during interviews.


### Optimal Solution (Two Pointers + In-Place Reversal)

###  Core Idea

The optimal approach keeps space usage at **O(1)**. Here's how:

1. First, you **find the middle** of the list using the fast and slow pointer trick. Fast moves two steps at a time, slow moves one — so by the time fast reaches the end, slow is at the middle.

2. Then, you **reverse the second half** of the list starting from the middle.

3. Now, with two pointers — one from the original head and one from the start of the reversed half — you **compare the two halves**.

4. If all values match, it’s a palindrome.

Optionally, you can **reverse the second half back** to its original state to leave the list unchanged. This isn’t required in the LeetCode problem, but it's good practice in real-world code.

### Complexity

* Time: O(n)
* Space: O(1)
  (you reverse the list in-place, no extra structures)


### Code

```java
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // Step 1: Find middle using slow and fast pointers
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode secondHalfHead = reverse(slow);

        // Step 3: Compare first and second halves
        ListNode firstHalf = head;
        ListNode secondHalf = secondHalfHead;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // Optional: Restore the list
        reverse(secondHalfHead);

        return true;
    }

    // Helper function to reverse a linked list
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextTemp = head.next;
            head.next = prev;
            prev = head;
            head = nextTemp;
        }
        return prev;
    }
}
```


### How It Works (Visual Summary)

Let’s say the list is:
`1 → 2 → 3 → 2 → 1`

* After finding the middle (node `3`), you reverse `2 → 1` to `1 → 2`.
* Now compare `1 → 2 → 3` vs `1 → 2` (only compare till second half ends).
* All values match? ✅ It’s a palindrome.
