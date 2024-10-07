class Solution {
    public int countOdds(int low, int high) {
        int result = high - low;

        if(result % 2 == 0 && high % 2 == 1){
            return result / 2 + 1;
        }  else if(result % 2 == 1){
            return result / 2 + 1;
        } else{
            return result / 2;
        }
    }
}