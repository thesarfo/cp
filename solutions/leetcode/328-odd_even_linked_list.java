class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode oddHead = new ListNode(0);  
        ListNode evenHead = new ListNode(0); 
        ListNode oddTail = oddHead;
        ListNode evenTail = evenHead;

        ListNode temp = head;
        int index = 1;

        while (temp != null) {
            if (index % 2 == 1) {
                oddTail.next = temp;
                oddTail = oddTail.next;
            } else {
                evenTail.next = temp;
                evenTail = evenTail.next;
            }
            temp = temp.next;
            index++;
        }

        evenTail.next = null; 
        oddTail.next = evenHead.next; 

        return oddHead.next;
    }
}