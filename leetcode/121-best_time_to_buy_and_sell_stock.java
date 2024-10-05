class Solution {
    public int maxProfit(int[] prices) {
        int minimum = prices[0];
        int maxProfit = 0;
        int n = prices.length;

        for(int i = 0; i < n; i++){
            int cost = prices[i] - minimum;
            maxProfit = Math.max(maxProfit, cost);
            minimum = Math.min(minimum, prices[i]);
        }
        return maxProfit;
    }
}