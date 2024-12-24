import java.util.*;

public class Solution {
    public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.
        Arrays.sort(stalls);

        for(int distance = 1; distance <= stalls[stalls.length - 1] - stalls[0]; distance++){
            if(!canPlaceCows(stalls, k, distance)){
                return distance - 1;
            }
        }
        return stalls[stalls.length - 1] - stalls[0];
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