class Solution {
    public ListNode reverseList(ListNode head) {
      if (head == null || head.next == null)
        return head;
  
      ListNode newHead = reverseList(head.next);
      head.next.next = head;
      head.next = null;
      return newHead;
    }
  }

/* Optimal Solution */
class OptimalSolution {
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    ListNode forw = null;

    while (curr != null) {
      forw = curr.next;
      curr.next = prev;
      prev = curr;
      curr = forw;
    }
    return prev;
  }
}