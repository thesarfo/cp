import java.util.Scanner;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        sc.nextLine(); 

        while (T-- > 0) {
            int n = sc.nextInt(); 
            sc.nextLine();  
            String binaryString = sc.nextLine(); 
            
            int countZero = 0, countOne = 0;
            
            for (char ch : binaryString.toCharArray()) {
                if (ch == '0') {
                    countZero++;
                } else if (ch == '1') {
                    countOne++;
                }
            }
            
            if (countZero == n || countOne == n) {
                System.out.println(n); 
            } else {
                System.out.println(1); 
            }
        }
    }
}
