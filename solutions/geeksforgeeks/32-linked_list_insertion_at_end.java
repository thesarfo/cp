/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/
class Solution {
    // Function to insert a node at the end of the linked list.
    Node insertAtEnd(Node head, int x) {
        Node newNode = new Node(x);
        
        if (head == null) {
            return newNode;
        }
    
        Node temp = head;
        
        while (temp.next != null) {
            temp = temp.next;
        }
        
        temp.next = newNode;
        
        return head;
    }
}