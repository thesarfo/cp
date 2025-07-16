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


// another solution
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        List<Integer> ll = new ArrayList<>();
        ListNode temp = head;

        while (temp != null && temp.next != null) {
            ll.add(temp.val);
            temp = temp.next.next;
        }
        if (temp != null) ll.add(temp.val); // for odd length lists, temp will be at the last node

        temp = head.next;

        while (temp != null && temp.next != null) {
            ll.add(temp.val);
            temp = temp.next.next;
        }
        if (temp != null) ll.add(temp.val); // for even length lists, temp will be at the last node

        temp = head;
        int idx = 0;

        while (temp != null) {
            temp.val = ll.get(idx);
            idx++;
            temp = temp.next;
        }

        return head;
    }
}
