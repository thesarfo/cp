import java.util.*;

public class team {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int count = 0;
        
        while(t-- > 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if((a == 1 && b == 1) || (a == 1&& c == 1) || (b == 1 && c == 1)){
                count+=1;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
