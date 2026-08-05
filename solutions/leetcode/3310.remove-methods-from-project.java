/*
 * @lc app=leetcode id=3310 lang=java
 *
 * [3310] Remove Methods From Project
 */

// @lc code=start
class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] inv : invocations) {
            graph[inv[0]].add(inv[1]);
        }

        boolean[] suspicious = new boolean[n];
        boolean[] visited = new boolean[n];
        List<Integer> queue = new ArrayList<>();
        
        queue.add(k);
        visited[k] = true;
        suspicious[k] = true;
        
        int head = 0;
        while(head < queue.size()){
            int u = queue.get(head++);
            for(int v : graph[u]){
                if(!visited[v]){
                    visited[v] = true;
                    suspicious[v] = true;
                    queue.add(v);
                }
            }
        }

        for (int u = 0; u < n; u++) {
            if (!suspicious[u]) {
                for (int v : graph[u]) {
                    if (suspicious[v]) {
                        List<Integer> all = new ArrayList<>();
                        for (int i = 0; i < n; i++) all.add(i);
                        return all;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                result.add(i);
            }
        }
        return result;
    }
}

