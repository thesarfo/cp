class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalfHead = reverseList(slow);
        ListNode newHead = head;

        while(secondHalfHead != null){
            if(newHead.val != secondHalfHead.val){
                return false;
            }
            newHead = newHead.next;
            secondHalfHead = secondHalfHead.next;
        }
        reverseList(slow);
        return true;

    }

    private ListNode reverseList(ListNode head) {
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