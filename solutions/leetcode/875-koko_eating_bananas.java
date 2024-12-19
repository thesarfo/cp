class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = findMax(piles);
        int answer = high;  
        
        while (low <= high) {
            int mid = (low + high) / 2;
            int totalH = calculateTotalHours(piles, mid);
            
            if (totalH <= h) {
                answer = mid;  
                high = mid - 1;  
            } else {
                low = mid + 1;
            }
        }
        
        return answer; 
    }

    public int findMax(int[] v) {
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < v.length; i++) {
            maxi = Math.max(maxi, v[i]);
        }
        return maxi;
    }

    public int calculateTotalHours(int[] v, int hourly) {
        int totalH = 0;
        for (int i = 0; i < v.length; i++) {
            totalH += Math.ceil((double)(v[i]) / (double)(hourly));
        }
        return totalH;
    }
}
