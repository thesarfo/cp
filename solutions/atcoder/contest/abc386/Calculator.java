import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        
        int p = 0;
        int i = 0;
        
        p++;
        i++;
        
        while (i < S.length()) {
            if (i + 1 < S.length() && S.charAt(i) == '0' && S.charAt(i + 1) == '0') {
                p++;
                i += 2;
            } else {
                p++;
                i++;
            }
        }
        
        System.out.println(p);
        sc.close();
    }
}