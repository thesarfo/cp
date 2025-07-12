/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        int pos = 0;
        ListNode temp = head;
        Map<ListNode, Integer> mpp = new HashMap<>();

        while(temp != null){
            if(mpp.containsKey(temp)){
                return temp;
            }
            mpp.put(temp, mpp.getOrDefault(temp, 0) + 1);
            pos++;
            temp = temp.next;
        }

        return null;
    }

    // private ListNode findNode(int pos){
    //     for(int i = 0;i < pos; i++){

    //     }
    // }
}