import java.io.*;
 
public class Solution {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter writer = new PrintWriter(System.out);
    
    public static void main(String[] args) throws IOException {
        int testCases = Integer.parseInt(reader.readLine());
        
        while (testCases-- > 0) {
            solveProblem();
        }
        
        writer.flush();
    }
    
    private static void solveProblem() throws IOException {
        String[] input = reader.readLine().split(" ");
        int zeroCount = Integer.parseInt(input[0]);
        int oneCount = Integer.parseInt(input[1]);
        int targetCount = Integer.parseInt(input[2]);
        
        String result = generateBinaryString(zeroCount, oneCount, targetCount);
        writer.println(result);
    }
    
    private static String generateBinaryString(int zeroCount, int oneCount, int targetCount) {
        if (zeroCount == 0) {
            return (targetCount == oneCount) ? "1".repeat(oneCount) : "-1";
        }
        if (oneCount == 0) {
            return (targetCount == zeroCount) ? "0".repeat(zeroCount) : "-1";
        }
        
        StringBuilder result = new StringBuilder();
        
        if (zeroCount >= oneCount) {
            int difference = zeroCount - oneCount;
            if (targetCount < difference || targetCount > zeroCount) {
                return "-1";
            }
            
            result.append("0".repeat(targetCount));
            
            int remainingZeros = zeroCount - targetCount;
            int remainingOnes = oneCount;
            
            while (remainingZeros > 0 && remainingOnes > 0) {
                result.append('1');
                remainingOnes--;
                result.append('0');
                remainingZeros--;
            }
            
            if (remainingOnes > 0) {
                result.append("1".repeat(remainingOnes));
            }
        } else {
            int difference = oneCount - zeroCount;
            if (targetCount < difference || targetCount > oneCount) {
                return "-1";
            }
            
            result.append("1".repeat(targetCount));
            
            int remainingOnes = oneCount - targetCount;
            int remainingZeros = zeroCount;
            
            while (remainingOnes > 0 && remainingZeros > 0) {
                result.append('0');
                remainingZeros--;
                result.append('1');
                remainingOnes--;
            }
            
            if (remainingZeros > 0) {
                result.append("0".repeat(remainingZeros));
            }
        }
        
        return result.toString();
    }
}
