import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        long t = s.nextLong();
        int count = 0;
        
        while(t > 0){
            long i = t % 10;
            if(i == 4 || i == 7) count++;
            t /= 10;
        }
        System.out.println(count == 4 || count == 7 ? "YES" : "NO");
    }
    
}