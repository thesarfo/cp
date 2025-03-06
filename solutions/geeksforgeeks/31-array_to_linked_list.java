

// User function Template for Java

/*
class Node {
    int data;
    Node next;

    Node() { data = 0; }
    Node(int d) { data = d; }  //constructor to create a new node
}
*/
class Solution {
    static Node constructLL(int arr[]) {
        // code here
        Node head = arr[0];
        Node temp = head;
        
        for(int i = 1; i < arr.length; i++){
            temp.next = arr[i];
            temp = temp.next;
        }
        return head;
    }
}
