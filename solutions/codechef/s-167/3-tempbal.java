import java.util.*;
import java.io.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); 
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = sc.nextInt(); 
            int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }

            long imbalance = 0;
            long totalOperations = 0;

            for (int i = 0; i < N; i++) {
                imbalance += A[i];
                totalOperations += Math.abs(imbalance);
            }

            sb.append(totalOperations).append("\n");
        }

        System.out.print(sb);
    }
}
