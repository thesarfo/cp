class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(String c : operations){
            if (c.contains("--X") || c.contains("X--")){
                x--;
            } else if(c.contains("X++") || c.contains("++X")){
                x++;
            }
        }
        return x;
    }
}