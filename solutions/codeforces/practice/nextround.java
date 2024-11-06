import java.util.Scanner;

public class nextround {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        int count = 0;

        while (n-- > 0) {
            int i = sc.nextInt();
            if((i > 0) || (i > k)){
                count += 1;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
