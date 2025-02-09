import java.io.*;
import java.util.*;
 
public class Solution {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter writer = new PrintWriter(System.out);
    
    public static void main(String[] args) throws IOException {
        int testCases = Integer.parseInt(reader.readLine());
        
        while (testCases-- > 0) {
            String[] nm = reader.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            
            long[] firstArray = new long[n];
            long[] secondArray = new long[m];
            
            String[] firstInput = reader.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                firstArray[i] = Long.parseLong(firstInput[i]);
            }
            
            String[] secondInput = reader.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                secondArray[i] = Long.parseLong(secondInput[i]);
            }
            
            Arrays.sort(secondArray);
            
            boolean isPossible = solve(firstArray, secondArray);
            
            writer.println(isPossible ? "YES" : "NO");
        }
        
        writer.flush();
    }
    
    private static boolean solve(long[] firstArray, long[] secondArray) {
        long lowerBound = -1000000000000000000L;
        
        for (int i = 0; i < firstArray.length; i++) {
            long candidate1 = firstArray[i] >= lowerBound ? firstArray[i] : Long.MAX_VALUE;
            
            long candidate2 = Long.MAX_VALUE;
            long target = lowerBound + firstArray[i];
            
            int pos = Arrays.binarySearch(secondArray, target);
            if (pos < 0) {
                pos = -(pos + 1);
            }
            
            if (pos < secondArray.length) {
                candidate2 = secondArray[pos] - firstArray[i];
            }
            
            long candidate = Math.min(candidate1, candidate2);
            if (candidate == Long.MAX_VALUE) {
                return false;
            }
            lowerBound = candidate;
        }
        
        return true;
    }
}
