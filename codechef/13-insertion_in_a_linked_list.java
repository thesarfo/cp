class Node {
    public int value;
    public Node next;
    
    // Constructor to initialize the node with a given value
    public Node(int val) {
        value = val;
        next = null;
    }
}

class LinkedList {
    public Node head;
    
    public void insertFront(int value) {
        System.out.println("Inserting " + value);
        
        // Step 1: Create a new Node
        Node newNode = new Node(value);
        
        // Step 2: Set next of newNode to the current head
        newNode.next = head;
        
        // Step 3: Set newNode as the head
        head = newNode;
    }
    
    public int getHeadValue() {
        if (head == null) {
            return -1;
        } else {
            return head.value;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertFront(3);
        System.out.println("The value at the head is: " + list.getHeadValue());
        
        list.insertFront(2);
        System.out.println("The value at the head is: " + list.getHeadValue());
    }
}
