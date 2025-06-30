class Node{
    public int data;
    public Node next;
    public Node prev;

    public Node(int data, Node next, Node prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    // Constructor for creating a node with no next node 
    // this is useful for the last node in the list
    public Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class LinkedList{
    
}