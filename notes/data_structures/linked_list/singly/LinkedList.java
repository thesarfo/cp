package singly;

public class LinkedList implements ListI<E>{

    class Node<E>{
        E data;
        Node<E> next;

        public Node(E obj){
            data = obj;
            next = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int currentSize;

    public LinkedList(){
        head = null;
        tail = null;
        currentSize = 0;
    }

    // add to the head of the linked list
    public void addFirst(E obj) {
        Node<E> node = new Node<E>(obj);
        node.next = head;

        head = node;
        currentSize++; // keep track of the size of the linked list by incrementing or decrementing the size

    }

    // add to the tail of the linked list
    public void addLast(E obj) {
        Node<E> newNode = new Node<E>(obj);
        if (head == null) {
            head = tail = node;
            currentSize++;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        currentSize++;
        return;
    }

    // remove the first element of the linked list
    public E removeFirst() {
        if (head == null) {
            return null;
        }
        E temp = head.data;

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
        currentSize--;

        return temp;

    }
    
}

/* Boundary Conditions
 * 
 * 1. Empty Data Structure
 * 2. Single element in the data structure
 * 3. Adding / Removing from the beginning of the data structure
 * 4. Adding / Removing from the end of the data structure
 * 5. Working in the middle of the data structure
 */
