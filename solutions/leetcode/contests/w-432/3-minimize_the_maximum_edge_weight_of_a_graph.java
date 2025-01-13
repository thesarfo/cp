import java.util.*;

class Solution {
    public int minMaxWeight(int n, int[][] edges, int threshold) {
        int left = 1;
        int right = 1;
        for (int[] edge : edges) {
            right = Math.max(right, edge[2]);
        }
        
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canFormGraphWithMaxWeight(n, edges, threshold, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
    
    private boolean canFormGraphWithMaxWeight(int n, int[][] edges, int threshold, int maxWeight) {
        Map<Integer, List<Integer>> incomingGraph = new HashMap<>();
        Map<Integer, List<Integer>> outgoingEdgeWeights = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            incomingGraph.put(i, new ArrayList<>());
            outgoingEdgeWeights.put(i, new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if (w <= maxWeight) {
                incomingGraph.get(v).add(u);
                outgoingEdgeWeights.get(u).add(w);
            }
        }
        
        for (Map.Entry<Integer, List<Integer>> entry : outgoingEdgeWeights.entrySet()) {
            List<Integer> weights = entry.getValue();
            if (weights.size() > threshold) {
                Collections.sort(weights, Collections.reverseOrder());
                outgoingEdgeWeights.put(entry.getKey(), 
                    new ArrayList<>(weights.subList(0, threshold)));
            }
        }
        
        if (!canReachZeroFromAllNodes(n, incomingGraph)) {
            return false;
        }
        
        for (List<Integer> weights : outgoingEdgeWeights.values()) {
            if (weights.size() > threshold) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean canReachZeroFromAllNodes(int n, Map<Integer, List<Integer>> incomingGraph) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(0);
        visited[0] = true;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : incomingGraph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }
}