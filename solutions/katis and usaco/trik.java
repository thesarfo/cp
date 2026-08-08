import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int pos = 1;

        for (char c : s.toCharArray()) {
            if (c == 'A') {
                if(pos == 1){
                    pos = 2;
                }else if(pos == 2){
                    pos = 1;
                }
            } else if (c == 'B') {
                if(pos == 2){
                    pos = 3;
                }else if(pos == 3){
                    pos = 2;
                }
            } else if (c == 'C') {
                if(pos == 1){
                    pos = 3;
                }else if(pos == 3){
                    pos = 1;
                }
            }
        }

        System.out.println(pos);
    }
}
