class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1); 
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                prev.next = cur.next; 
            } else {
                prev = prev.next;
            }
            cur = cur.next;
        }

        return dummy.next;
    }
}