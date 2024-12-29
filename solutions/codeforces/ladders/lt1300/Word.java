import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String word = s.next();
        int uc = 0, lc = 0;

        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) uc++;
            else lc++;
        }

        System.out.println(uc > lc ? word.toUpperCase() : word.toLowerCase());
    }
}
