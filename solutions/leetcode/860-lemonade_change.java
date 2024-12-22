class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0, tens = 0;

        for (int bill : bills) {
            if (bill == 5) {
                fives++; 
            } else if (bill == 10) {
                if (fives > 0) {
                    fives--; 
                    tens++;  
                } else {
                    return false; 
                }
            } else if (bill == 20) {
                if (tens > 0 && fives > 0) {
                    tens--; 
                    fives--; 
                } else if (fives >= 3) {
                    fives -= 3; 
                } else {
                    return false; 
                }
            }
        }

        return true; 
    }
}

