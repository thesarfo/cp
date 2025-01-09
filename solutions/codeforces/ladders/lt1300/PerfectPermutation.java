import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n % 2 != 0) System.out.println("-1");
        else{
            StringBuilder result = new StringBuilder();
            for(int i = 1; i <= n; i+=2){
                result.append(i + 1).append(" ").append(i).append(" ");
            }
            System.out.println(result.toString().trim());
        }
        sc.close();
    }
}