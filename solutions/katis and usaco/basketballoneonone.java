import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        char[] s = str.toCharArray();

        int a = 0;
        int b = 0;

        for (int i = 0; i < s.length; i += 2) {

            if (s[i] == 'A') {
                a += s[i + 1] - '0';
            } else {
                b += s[i + 1] - '0';
            }

            if (a >= 11 || b >= 11) {
                if (Math.abs(a - b) >= 2) {
                    System.out.println(a > b ? "A" : "B");
                    return;
                }
            }
        }
    }
}
