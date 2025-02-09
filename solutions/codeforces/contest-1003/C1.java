import java.util.Scanner;
 
public class Soluton {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); 
 
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            int[] b = new int[m];
            for (int j = 0; j < m; j++) {
                b[j] = scanner.nextInt();
            }
 
            boolean possible = canSort(a, b[0]);
            System.out.println(possible ? "YES" : "NO");
        }
    }
 
    private static boolean canSort(int[] a, int b) {
        int n = a.length;
        int[] modifiedA = new int[n];
        modifiedA[0] = Math.min(a[0], b - a[0]); 
 
        for (int i = 1; i < n; i++) {
            int option1 = a[i]; 
            int option2 = b - a[i]; 
 
            if (option1 >= modifiedA[i - 1] && option2 >= modifiedA[i - 1]) {
                modifiedA[i] = Math.min(option1, option2);
            } else if (option1 >= modifiedA[i - 1]) {
                modifiedA[i] = option1;
            } else if (option2 >= modifiedA[i - 1]) {
                modifiedA[i] = option2;
            } else {
                return false; 
            }
        }
 
        return true;
    }
}
