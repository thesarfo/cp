public class Solution {

    public void dfs(int nd, int pt, int dd, int rt, int k, int[] ddg, List<List<Integer>> adj) {
        if (dd >= k) return;  
        ddg[rt]++;  
        for (int nb : adj.get(nd)) {
            if (nb != pt) {
                dfs(nb, nd, dd + 1, rt, k, ddg, adj);
            }
        }
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1; 
        int m = edges2.length + 1; 

        List<List<Integer>> af = new ArrayList<>();
        List<List<Integer>> as = new ArrayList<>();
        for (int i = 0; i < n; i++) af.add(new ArrayList<>());
        for (int i = 0; i < m; i++) as.add(new ArrayList<>());

        for (int[] e : edges1) {
            int u = e[0], v = e[1];
            af.get(u).add(v);
            af.get(v).add(u);
        }

        for (int[] e : edges2) {
            int u = e[0], v = e[1];
            as.get(u).add(v);
            as.get(v).add(u);
        }

        int[] go = new int[n];
        int[] gt = new int[m];

        for (int i = 0; i < n; i++) {
            dfs(i, -1, 0, i, k + 1, go, af);
        }

        for (int i = 0; i < m; i++) {
            dfs(i, -1, 0, i, k, gt, as);
        }

        int mx = Integer.MIN_VALUE;
        for (int value : gt) {
            if (value > mx) {
                mx = value;
            }
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = go[i] + mx;
        }

        return ans;
    }
}