class Solution {
    public long splitArray(int[] nums) {
        int n = nums.length;
        long[] p = new long[n + 1];
        long ts = 0;
        for(int i = 0; i < n; i++){
            ts += nums[i];
            p[i + 1] = ts;
        }

        boolean[] lv = new boolean[n + 1];
        lv[1] = true;
        for(int i = 2; i <= n; i++){
            lv[i] = lv[i - 1] && (nums[i - 2] < nums[i - 1]);

        }

        boolean[] rv = new boolean[n];
        rv[n - 1] = true;
        for(int i = n - 2; i >= 0; i--){
            rv[i] = rv[i + 1] && (nums[i] > nums[i + 1]);
        }
        long mdif = Long.MAX_VALUE;
        boolean vsf = false;

        for(int i = 1; i < n; i++){
            if(lv[i] && rv[i]){
                vsf = true;
                long sumLeft = p[i];
                long crdf = Math.abs(2 * sumLeft - ts);
                mdif = Math.min(mdif, crdf);
            }
        }
        return vsf ? mdif : -1;
        
    }
}