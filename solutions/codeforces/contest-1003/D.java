import java.io.*;
import java.util.*;
 
public class Solution {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter writer = new PrintWriter(System.out);
    
    static class ArrayStats {
        long totalSum;    
        long runningScore; 
        
        ArrayStats(long totalSum, long runningScore) {
            this.totalSum = totalSum;
            this.runningScore = runningScore;
        }
    }
    
    public static void main(String[] args) throws IOException {
        int testCases = Integer.parseInt(reader.readLine());
        
        while (testCases-- > 0) {
            String[] input = reader.readLine().split(" ");
            int arrayCount = Integer.parseInt(input[0]);
            int arrayLength = Integer.parseInt(input[1]);
            
            List<ArrayStats> arrayStatsList = new ArrayList<>();
            
            for (int i = 0; i < arrayCount; i++) {
                input = reader.readLine().split(" ");
                long currentSum = 0;
                long currentScore = 0;
                
                for (int j = 0; j < arrayLength; j++) {
                    int element = Integer.parseInt(input[j]);
                    currentSum += element;
                    currentScore += currentSum;
                }
                
                arrayStatsList.add(new ArrayStats(currentSum, currentScore));
            }
            
            arrayStatsList.sort((a, b) -> Long.compare(b.totalSum, a.totalSum));
            
            long finalScore = 0;
            long previousArraysSum = 0;
            
            for (ArrayStats stats : arrayStatsList) {
                finalScore += stats.runningScore + arrayLength * previousArraysSum;
                previousArraysSum += stats.totalSum;
            }
            
            writer.println(finalScore);
        }
        
        writer.flush();
    }
}
