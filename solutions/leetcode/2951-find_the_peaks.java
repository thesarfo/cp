class Solution {
    public List<Integer> findPeaks(int[] mountain) {
        int n = mountain.length;
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(i == 0 || i == n-1){
                continue;
            }
            if(mountain[i] > mountain[i-1] && mountain[i] > mountain[i+1]){
                result.add(i);
            }
        }
        return result;
    }
}