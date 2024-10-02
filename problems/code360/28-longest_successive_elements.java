import java.util.Set;
import java.util.HashSet;

public class Solution {
    public static int longestSuccessiveElements(int []a) {
        // Write your code here.
        if(a.length == 0) return 0;

        Set<Integer> res = new HashSet<>();
        for(int num : a){
            res.add(num);
        }

        int longest = 0;

        for(int num : res){
            if(!res.contains(num - 1)){
                int currentNum = num;
                int currentStreak = 1;

                while(res.contains(currentNum + 1)){
                    currentNum++;
                    currentStreak++;
                }

                longest = Math.max(longest, currentStreak);
            }
        }
        return longest;
    }
}