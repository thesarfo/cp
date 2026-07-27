class StackArray {

    private int[] arr;
    private int top;
    private int capacity;

    public StackArray(int size) {
        this.capacity = size;
        this.arr = new int[size];
        this.top = -1;
    }

    public void push(int x) {
        if (top == capacity - 1) {
            System.out.println("stack is full");
            return;
        }
        arr[++top] = x;
        System.out.println("inserted: " + x);
    }

    public int pop() {
        if (top == -1) {
            System.out.println("stack is empty / underflow");
            return -1;
        }
        System.out.println("popped " + arr[top] + " from stack");
        return arr[top--];
    }

    public int peek() {
        if (top == -1) {
            System.out.println("stack is empty / underflow");
            return -1;
        }
        System.out.println("top: " + arr[top]);
        return arr[top];
    }

    public static void main(String[] args) {
        StackArray stack = new StackArray(3);
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
