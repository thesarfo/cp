class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int pi = 0;

        for (int x : pushed) {
            stack.push(x);

            while (!stack.isEmpty() && stack.peek() == popped[pi]) {
                stack.pop();
                pi++;
            }
        }

        return stack.isEmpty();
    }
}
