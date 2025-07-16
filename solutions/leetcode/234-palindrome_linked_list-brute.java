class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();

        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

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
