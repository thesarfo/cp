import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.next();
        int n = S.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == 'A') {
                for (int d = 1; i + 2 * d < n; d++) {
                    int j = i + d;
                    int k = j + d;
                    if (S.charAt(j) == 'B' && S.charAt(k) == 'C') {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
        scanner.close();
    }
}
