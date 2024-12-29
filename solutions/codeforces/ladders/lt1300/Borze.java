import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '.') {
                sb.append(0);
            } else if (c == '-') {
                if (i + 1 < s.length() && s.charAt(i + 1) == '.') {
                    sb.append(1);
                    i++; 
                } else if (i + 1 < s.length() && s.charAt(i + 1) == '-') {
                    sb.append(2);
                    i++; 
                }
            }
        }

        System.out.println(sb.toString());
        sc.close();
    }
}
