class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return new int[0][];
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> ans = new ArrayList<>();
        
        for(int[] interval : intervals){
            if(ans.isEmpty() || interval[0] > ans.get(ans.size() - 1)[1]){
                ans.add(interval);
            } else{
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], interval[1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}