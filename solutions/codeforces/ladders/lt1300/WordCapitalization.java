import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String w = s.next();
        
        System.out.println(Character.toUpperCase(w.charAt(0)) + w.substring(1));
    }
}
