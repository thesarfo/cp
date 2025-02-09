import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
 
        for (int i = 0; i < t; i++) {
            String singularNoun = scanner.nextLine();
            String pluralNoun = convertToPlural(singularNoun);
            System.out.println(pluralNoun);
        }
    }
 
    private static String convertToPlural(String singularNoun) {
        return singularNoun.substring(0, singularNoun.length() - 2) + "i";
    }
}
