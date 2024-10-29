class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int greatest = candies[0];
        int n = candies.length;
        List<Boolean> result = new ArrayList<>(Collections.nCopies(n, false));

        for(int i = 0; i < n; i++){
            if(candies[i] > greatest){
                greatest = candies[i];
            }
        }

        for (int i = 0; i < n; i++) {
    if ((candies[i] + extraCandies) >= greatest) {
        result.set(i, true); 
    }
}
        return result;
    }
}