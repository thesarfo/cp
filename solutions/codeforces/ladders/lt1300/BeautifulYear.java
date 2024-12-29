import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        
        int year = n + 1;
        
        while (!isDistinct(year)) {
            year++;
        }
        
        System.out.println(year);
    }

    public static boolean isDistinct(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n > 0) {
            int digit = n % 10;
            if (seen.contains(digit)) {
                return false;
            }
            seen.add(digit);
            n /= 10;
        }
        return true;
    }
}
