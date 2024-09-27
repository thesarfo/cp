#include <bits/stdc++.h> 
int maximumProfit(vector<int> &prices){
    // Write your code here.
    int minimumPrice = prices[0];
    int maxProfit = 0;

    for(int i = 0; i < prices.size(); i++){
        int cost = prices[i] - minimumPrice;
        maxProfit = std::max(maxProfit, cost);
        minimumPrice = std::min(minimumPrice, prices[i]);
    }
    return maxProfit;
}