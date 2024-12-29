import java.util.ArrayList;

public class Solution {
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
        int totalSum = 0;
        int maxBoard = 0;
        
        for (int board : boards) {
            totalSum += board;
            maxBoard = Math.max(maxBoard, board);
        }
        
        int low = maxBoard, high = totalSum;
        int result = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canDistributeBoards(boards, k, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return result;
    }
    
    private static boolean canDistributeBoards(ArrayList<Integer> boards, int k, int maxLoad) {
        int paintersRequired = 1; 
        int currentLoad = 0;
        
        for (int board : boards) {
            if (currentLoad + board > maxLoad) {
                paintersRequired++;
                currentLoad = board;
                if (paintersRequired > k) {
                    return false;  
                }
            } else {
                currentLoad += board;
            }
        }
        
        return true;
    }
}
