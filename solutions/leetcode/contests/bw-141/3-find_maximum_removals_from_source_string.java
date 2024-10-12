class Solution {
    public int maxRemovals(String source, String pattern, int[] targetIndices) {
        int sourceLength = source.length();
        int patternLength = pattern.length();

        int[] minRemovals = new int[patternLength + 1];
        Arrays.fill(minRemovals, Integer.MAX_VALUE); 
        minRemovals[0] = 0; 

        boolean[] canRemove = new boolean[sourceLength];
        for (int index : targetIndices) {
            canRemove[index] = true;
        }

        for (int i = 0; i < sourceLength; i++) {
            for (int j = patternLength; j > 0; j--) {
                if (source.charAt(i) == pattern.charAt(j - 1) && minRemovals[j - 1] != Integer.MAX_VALUE) {
                    minRemovals[j] = Math.min(minRemovals[j], minRemovals[j - 1] + (canRemove[i] ? 1 : 0));
                }
            }
        }

        return targetIndices.length - (minRemovals[patternLength] == Integer.MAX_VALUE ? 0 : minRemovals[patternLength]);
    }
}