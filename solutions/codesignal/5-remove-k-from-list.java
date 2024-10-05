// Singly-linked lists are already defined with this interface:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
ListNode<Integer> solution(ListNode<Integer> l, int k) {
    while (l != null && l.value == k) {
        l = l.next;
    }
    
    if (l == null) {
        return null;
    }
    
    ListNode<Integer> current = l;
    while (current.next != null) {
        if (current.next.value == k) {
            current.next = current.next.next;
        } else {
            current = current.next;
        }
    }
    
    return l;
}
