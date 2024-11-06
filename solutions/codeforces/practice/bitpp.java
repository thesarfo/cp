import java.util.*;

public class bitpp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int x = 0;

        while(t-- > 0){
            String a = sc.nextLine();
            if(a.contains("++")){
                x--;
            } else{
                x++;
            }
        }
        System.out.println(x);
    }
}
