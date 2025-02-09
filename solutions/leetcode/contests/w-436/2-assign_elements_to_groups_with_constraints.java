class Solution {
    public int[] assignElements(int[] groups, int[] elements) {
        int n = groups.length, assigned[] = new int[n];
        Map<Integer, Integer> elementMap = new HashMap<>();
        for (int j = 0; j < elements.length; j++) elementMap.putIfAbsent(elements[j], j);
        
        for (int i = 0; i < n; i++) {
            int currentGroup = groups[i], smallestIndex = Integer.MAX_VALUE;
            for (int j = 1; j * j <= currentGroup; j++) {
                if (currentGroup % j == 0) {
                    if (elementMap.containsKey(j)) smallestIndex = Math.min(smallestIndex, elementMap.get(j));
                    int complement = currentGroup / j;
                    if (elementMap.containsKey(complement)) smallestIndex = Math.min(smallestIndex, elementMap.get(complement));
                }
            }
            assigned[i] = (smallestIndex != Integer.MAX_VALUE) ? smallestIndex : -1;
        }
        return assigned;
    }
}
