package data_structures.linked_list;

public class Node {

    public String data;
    private Node next;
  
    public Node(String data) {
      this.data = data;
      this.next = null;
    }
  
    public void setNextNode(Node node) {
      this.next = node;
    }
  
    public Node getNextNode() {
      return this.next;
    }
  
  }
