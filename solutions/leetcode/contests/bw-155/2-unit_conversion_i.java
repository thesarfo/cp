class Solution {
    public int[] baseUnitConversions(int[][] conversions) {
        int n = conversions.length + 1; 
        int MOD = 1_000_000_007;
        List<List<int[]>> graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] conversion : conversions) {
            int source = conversion[0];
            int target = conversion[1];
            int factor = conversion[2];
            graph.get(source).add(new int[]{target, factor});
        }
        int[] result = new int[n];
        boolean[] visited = new boolean[n];
        dfs(graph, 0, 1, result, visited, MOD);
        
        return result;
    }
        
    private void dfs(List<List<int[]>> graph, int currentUnit, long currentFactor, 
                    int[] result, boolean[] visited, int MOD) {
        visited[currentUnit] = true;
        
        result[currentUnit] = (int)(currentFactor % MOD);
        
        for (int[] edge : graph.get(currentUnit)) {
            int nextUnit = edge[0];
            int conversionFactor = edge[1];
            
            if (!visited[nextUnit]) {
                long newFactor = (currentFactor * conversionFactor) % MOD;
                dfs(graph, nextUnit, newFactor, result, visited, MOD);
            }
        }
    }
}