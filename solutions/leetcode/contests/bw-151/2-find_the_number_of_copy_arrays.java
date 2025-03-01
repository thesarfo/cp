class Solution {
    public int countArrays(int[] original, int[][] bounds) {
        int n = original.length;
        long lower = Long.MIN_VALUE;
        long upper = Long.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            long diff = original[i] - original[0];
            long currentLower = bounds[i][0] - diff;
            long currentUpper = bounds[i][1] - diff;
            
            lower = Math.max(lower, currentLower);
            upper = Math.min(upper, currentUpper);
            
            if (lower > upper) {
                return 0;
            }
        }
        
        return (int) (upper - lower + 1);
    }
}
