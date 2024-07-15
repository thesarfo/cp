// Singly-linked lists are already defined with this interface:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
boolean solution(ListNode<Integer> l) {
    if (l == null || l.next == null) {
        return true;
    }
    
    ListNode<Integer> slow = l;
    ListNode<Integer> fast = l;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    
    ListNode<Integer> secondHalf = reverseLinkedList(slow);
    
    ListNode<Integer> firstHalf = l;
    while (secondHalf != null) {
        if (!firstHalf.value.equals(secondHalf.value)) {
            return false;
        }
        firstHalf = firstHalf.next;
        secondHalf = secondHalf.next;
    }
    
    return true;
}

private ListNode<Integer> reverseLinkedList(ListNode<Integer> head) {
    ListNode<Integer> prev = null;
    ListNode<Integer> current = head;
    ListNode<Integer> next = null;
    
    while (current != null) {
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    
    return prev;
}

