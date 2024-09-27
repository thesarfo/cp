import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution{
    public static int maximumProfit(ArrayList<Integer> prices){
        // Write your code here.
        int minimumPrice = prices.get(0);
        int maxProfit = 0;
        
        for(int i = 0; i < prices.size(); i++){
            int cost = prices.get(i) - minimumPrice;
            maxProfit = Math.max(maxProfit, cost);
            minimumPrice = Math.min(minimumPrice, prices.get(i));
        }
        return maxProfit;
    }
}