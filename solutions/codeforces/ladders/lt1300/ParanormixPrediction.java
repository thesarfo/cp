import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        
        System.out.println(isNextPrime(n) == m ? "YES" : "NO");
    }

    
        public static int isNextPrime(int num) {
        int next = num + 1; 
        while (!isPrime(next)) {
            next++;
        }
        return next;
    }
    
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}