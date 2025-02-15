import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String S1 = scanner.next();
        String S2 = scanner.next();
        
        if (S1.equals("sick") && S2.equals("sick")) {
            System.out.println(1);
        } else if (S1.equals("sick") && S2.equals("fine")) {
            System.out.println(2);
        } else if (S1.equals("fine") && S2.equals("sick")) {
            System.out.println(3);
        } else if (S1.equals("fine") && S2.equals("fine")) {
            System.out.println(4);
        }
        
        scanner.close();
    }
}