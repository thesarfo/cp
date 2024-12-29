import java.util.*;

public class Solution {
    public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.
        Arrays.sort(stalls);

        int low = 1, high = stalls[stalls.length - 1] - stalls[0];
        int result = 0;

        while(low <= high){
            int mid = (low + high) / 2;

            if(canPlaceCows(stalls, k, mid)){
                result = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return result;
    }

    static boolean canPlaceCows(int[] stalls, int cows, int distance){
        int count = 1;
        int lastPosition = stalls[0];

        for(int i = 0; i < stalls.length; i++){
            if(stalls[i] - lastPosition >= distance){
                count++;
                lastPosition = stalls[i];
            }
            if (count == cows) return true;
        }
        return false;
    }
}