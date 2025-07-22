/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) return head;

        ListNode temp = head;
        ListNode prevGroupTail = null;

        ListNode newHead = null;

        while(temp != null){
            ListNode kth = getKthNode(temp, k);
            if(kth == null){
                if(prevGroupTail != null){
                    prevGroupTail.next = temp;
                }
                break;
            }

            ListNode nextGroupHead = kth.next;
            kth.next = null;

            ListNode reversedGroupHead = reverseList(temp);

            if(prevGroupTail != null){
                prevGroupTail.next = reversedGroupHead;
            }else{
                newHead = reversedGroupHead;
            }

            prevGroupTail = temp;

            temp = nextGroupHead;
            
        }
        return newHead != null ? newHead : head;
    }

    private ListNode getKthNode(ListNode node, int k) {
        while (node != null && k > 1) {
            node = node.next;
            k--;
        }
        return node;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }

        return prev;
    }
}