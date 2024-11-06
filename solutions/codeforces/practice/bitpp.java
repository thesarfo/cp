import java.util.*;

public class bitpp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        int x = 0;

        while(t-- > 0){
            String a = sc.nextLine();
            if(a.contains("++")){
                x+=1;
            } else if (a.contains("--")){
                x-=1;
            }
        }
        System.out.println(x);
    }
}
