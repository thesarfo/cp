import java.util.*; 
import java.io.*; 

public class Solution {
    public static long maxSubarraySum(int[] arr, int n) {
        if (n == 0) {
            return 0;
        }

        long maxSoFar = arr[0];  
        long currentSum = 0;      

        for (int num : arr) {
            currentSum += num;  

            maxSoFar = Math.max(currentSum, maxSoFar);

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSoFar < 0 ? 0 : maxSoFar;
    }
}
