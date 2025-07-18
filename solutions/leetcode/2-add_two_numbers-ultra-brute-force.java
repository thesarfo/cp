class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        
        while (l1 != null) {
            num1.insert(0, l1.val); 
            l1 = l1.next;
        }
        
        while (l2 != null) {
            num2.insert(0, l2.val); 
            l2 = l2.next;
        }

        BigInteger n1 = new BigInteger(num1.toString());
        BigInteger n2 = new BigInteger(num2.toString());
        BigInteger sum = n1.add(n2);

        String sumStr = new StringBuilder(sum.toString()).reverse().toString();
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (char c : sumStr.toCharArray()) {
            current.next = new ListNode(Character.getNumericValue(c));
            current = current.next;
        }

        return dummy.next;
    }
}
