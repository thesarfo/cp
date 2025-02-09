import java.io.*;
 
public class Solution {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter writer = new PrintWriter(System.out);
    
    public static void main(String[] args) throws IOException {
        int testCases = Integer.parseInt(reader.readLine());
        
        while (testCases-- > 0) {
            String inputString = reader.readLine();
            int result = findMinimumLength(inputString);
            writer.println(result);
        }
        
        writer.flush();
    }
    
    private static int findMinimumLength(String inputString) {
        boolean hasAdjacentDuplicates = false;
        
        for (int i = 0; i < inputString.length() - 1; i++) {
            if (inputString.charAt(i) == inputString.charAt(i + 1)) {
                hasAdjacentDuplicates = true;
                break;
            }
        }
        
        return hasAdjacentDuplicates ? 1 : inputString.length();
    }
}
