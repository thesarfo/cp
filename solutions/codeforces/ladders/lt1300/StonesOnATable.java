import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String w = s.next();

        int count = 0;

            for(int i = 1; i < w.length(); i++){
            if(w.charAt(i) == w.charAt(i - 1)) count++;
            }
        System.out.println(count);
    }
}