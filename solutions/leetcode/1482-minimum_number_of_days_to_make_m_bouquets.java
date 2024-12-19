class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long val = (long) m * k;
        if(val > bloomDay.length) return -1;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int i = 0; i < bloomDay.length; i++){
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }

        while(low < high){
            int mid = (low + high) / 2;

            if(possible(bloomDay, mid, m, k)){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean possible(int[] bloomDay, int day, int m, int k){
        int count = 0;
        int numBouq = 0;

        for(int i = 0; i < bloomDay.length; i++){
            if(bloomDay[i] <= day) count++;
            else{
                numBouq += count / k;
                count = 0;
            }
        }
        numBouq += count / k;
        return numBouq >= m;
    }
}