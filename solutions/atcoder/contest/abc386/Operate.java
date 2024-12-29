import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int K = sc.nextInt();  
        String S = sc.next();
        String T = sc.next();
        
        if (S.equals(T)) {
            System.out.println("Yes");
            sc.close();
            return;
        }
        
        if (Math.abs(S.length() - T.length()) > 1) {
            System.out.println("No");
            sc.close();
            return;
        }
        
        if (S.length() == T.length()) {
            int d = 0;
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) != T.charAt(i)) {
                    d++;
                    if (d > 1) break;
                }
            }
            System.out.println(d == 1 ? "Yes" : "No");
            sc.close();
            return;
        }
        
        if (S.length() + 1 == T.length()) {
            boolean p = false;
            int m = 0;
            int j = 0; 
            
            for (int i = 0; i < T.length(); i++) {
                if (j < S.length() && S.charAt(j) == T.charAt(i)) {
                    j++;
                } else {
                    m++;
                    if (m > 1) break;
                }
            }
            System.out.println(m == 1 ? "Yes" : "No");
            sc.close();
            return;
        }
        
        if (S.length() == T.length() + 1) {
            int m = 0;
            int j = 0; 
            
            for (int i = 0; i < S.length(); i++) {
                if (j < T.length() && S.charAt(i) == T.charAt(j)) {
                    j++;
                } else {
                    m++;
                    if (m > 1) break;
                }
            }
            System.out.println(m == 1 ? "Yes" : "No");
        }
        
        sc.close();
    }
}