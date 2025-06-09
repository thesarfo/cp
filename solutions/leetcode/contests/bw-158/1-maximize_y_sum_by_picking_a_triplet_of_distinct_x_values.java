class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        Map<Integer, Integer> maxYForX = new HashMap<>();
        
        for (int i = 0; i < x.length; i++) maxYForX.put(x[i], Math.max(maxYForX.getOrDefault(x[i], 0), y[i]));
        
        if (maxYForX.size() < 3) return -1;
        
        List<Integer> maxYValues = new ArrayList<>(maxYForX.values());
        maxYValues.sort(Collections.reverseOrder());

        return maxYValues.get(0) + maxYValues.get(1) + maxYValues.get(2);
    }
}
