class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        long[] pfx = new long[n + 1];
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                pfx[i + 1] = pfx[i] + 1;
            } else {
                pfx[i + 1] = pfx[i] - 1;
            }
        }
        long res = 0;
        Deque<int[]> st = new ArrayDeque<>();
        st.push(new int[]{0, n});

        Map<String, Long> memo = new HashMap<>();

        while(!st.isEmpty()){
            int[] rg = st.pop();
            int l = rg[0], r = rg[1];
            if(l >= r) continue;
            int m = (l + r) >> 1;
            st.push(new int[]{l, m});
            st.push(new int[]{m + 1, r});

            List<Integer> lft = new ArrayList<>();
            List<Integer> rht = new ArrayList<>();
            for(int i = l; i <= m; i++) lft.add(i);
            for(int i = m + 1; i <= r; i++)rht.add(i);

            lft.sort(Comparator.comparingLong(i -> pfx[i]));
            rht.sort(Comparator.comparingLong(i -> pfx[i]));

            int t = 0;
            for(int y : rht){
                while(t < lft.size() && pfx[lft.get(t)] <= pfx[y] - 1) t++;
                res += t;
            }
        }
        return res;
    }
}