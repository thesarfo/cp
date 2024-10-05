public class 1518-water_bottles {
    
}
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = numBottles; 
        int emptyBottles = numBottles;

        while (emptyBottles >= numExchange) {
            int exchangedBottles = emptyBottles / numExchange; 
            total += exchangedBottles; 
            emptyBottles = exchangedBottles + (emptyBottles % numExchange);
        }

        return total;
    }
}