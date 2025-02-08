import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = stack.peek() + 1;
            }
            
            stack.push(i);
        }
        
        for (int res : result) {
            System.out.print(res + " ");
        }
    }
}
