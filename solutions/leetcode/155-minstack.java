class MinStack {

    ArrayDeque<Integer> minstack = new ArrayDeque<>();
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    int min = Integer.MAX_VALUE;

    public MinStack() {
    }

    public void push(int value) {
        stack.push(value);

        if(minstack.isEmpty()){
            minstack.push(value);
        }else{
            minstack.push(Math.min(value, minstack.peek()));
        }
    }

    public void pop() {
        stack.pop();
        minstack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }
}

