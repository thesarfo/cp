class StackLinkedList<T> {

    private class Node {
        T data;
        Node next;

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node top;
    private int size;

    public StackLinkedList() {
        top = null;
        size = 0;
    }

    public void push(T data) {
        top = new Node(data, top);
        size++;
    }

    public T pop() {
        if (top == null) {
            System.out.println("Stack is empty / Underflow");
            return null;
        }

        T value = top.data;
        top = top.next;
        size--;

        System.out.println("Popped: " + value);
        return value;
    }

    public T peek() {
        if (top == null) {
            System.out.println("Stack is empty");
            return null;
        }

        System.out.println("Top: " + top.data);
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        StackLinkedList<Integer> stack = new StackLinkedList<>();

        stack.push(6);
        stack.push(2);
        stack.push(4);

        stack.pop();
        stack.peek();
        stack.pop();
        stack.pop();
        stack.pop();
    }
}
