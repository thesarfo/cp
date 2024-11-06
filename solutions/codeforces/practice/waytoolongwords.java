import java.util.Scanner;

public class waytoolongwords{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();


        while(t-- > 0){
            String s = sc.nextLine();
            if(s.length() > 10){
                System.out.println(s.substring(0,1) + (s.length() - 2) + s.substring(s.length() - 1));
            }else{
                System.out.println(s);
            }
        }
    }
}