### **Problem:**  
You are given an array where each element represents the price of a stock on a specific day. The goal is to determine the best day to **buy** and the best day to **sell** to maximize profit.  
- You can only make one transaction (buy and sell once).
- You must buy before you sell.

[Leetcode 121](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/)

---

### **Example:**
Given the array `[7, 1, 5, 3, 6, 4]`:
- **Buy** on day 2 (price `1`).
- **Sell** on day 5 (price `6`).
- Profit = `6 - 1 = 5`.

---

### **Key Concept:**
To maximize profit:
1. **Buy at the lowest price** before selling.
2. **Sell at the highest price** after buying.

---

### **Approach:**
1. **Track the minimum price** as you iterate through the array.
   - Initially, set the first day's price as the minimum.
2. For each day `i`, calculate the potential profit/loss if you sell on day `i`.
   - cost = `price[i] - minPrice`.
3. **Update the maximum profit** whenever you find a larger profit.
4. **Update the minimum price** as you progress if you find a smaller price.

---

### **Step-by-step Example (Array: `[7, 1, 5, 3, 6, 4]`):**
- Day 1: Price = `7` → Set `minPrice = 7`.
- Day 2: Price = `1` → New `minPrice = 1`.
- Day 3: Price = `5` → Profit = `5 - 1 = 4`. Max profit so far = `4`.
- Day 4: Price = `3` → Profit = `3 - 1 = 2`. Max profit remains `4`.
- Day 5: Price = `6` → Profit = `6 - 1 = 5`. New max profit = `5`.
- Day 6: Price = `4` → Profit = `4 - 1 = 3`. Max profit remains `5`.

---

### **Final Result:**
- **Max Profit = 5** (Buy on day 2 at `1`, sell on day 5 at `6`).

---

### **Key Insight:**
For each day, you are simply:
1. Checking the best price you could have bought at (lowest price up to that day).
2. Calculating the profit if you sold on that day.
3. Keeping track of the best profit found.

---
Below is a java implementation

```java
int minimum = prices[0];
int maxProfit = 0;
int n = prices.length;

for(int i = 0; i < n; i++){
    int cost = prices[i] - minimum;
    maxProfit = Math.max(maxProfit, cost);
    minimum = Math.min(minimum, prices[i]);
}
return maxProfit;
```