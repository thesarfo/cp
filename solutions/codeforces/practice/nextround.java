import java.util.Scanner;

public class nextround {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        int count = 0;

        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }
        int thresholdScore = scores[k - 1];
        for (int score : scores) {
            if (score >= thresholdScore && score > 0) {
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
