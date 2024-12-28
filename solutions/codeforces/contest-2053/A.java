import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 

        while (t-- > 0) {
            int n = sc.nextInt(); 
            int[] arr = new int[n];
            
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            
            Arrays.sort(arr);
            
            if (arr[0] + arr[1] <= arr[n - 1]) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
        
        sc.close();
    }
}
