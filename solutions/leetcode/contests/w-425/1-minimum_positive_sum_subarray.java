class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int mns = Integer.MAX_VALUE; 

        for (int lth = l; lth <= r; lth++) {
            int crs = 0;
            for (int i = 0; i < lth; i++) {
                crs += nums.get(i);
            }

            if (crs > 0) {
                mns = Math.min(mns, crs);
            }

            for (int i = lth; i < n; i++) {
                crs += nums.get(i) - nums.get(i - lth);

                if (crs > 0) {
                    mns = Math.min(mns, crs);
                }
            }
        }
        return mns == Integer.MAX_VALUE ? -1 : mns;
    }
}