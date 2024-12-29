import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.next(), b = sc.next();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < a.length(); i++){
            int ac = a.charAt(i) - '0';
            int bc = b.charAt(i) - '0';

            sb.append((ac ^ bc));
        }
        System.out.println(sb.toString());
    }
}