class Solution {
    public int minLength(String s, int maxOps) {
        int n = s.length();
        int low = 1, high = n; 
        int minLength = n;  

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canReducePrefix(mid, s, maxOps)) {
                minLength = mid;
                high = mid - 1; 
            } else {
                low = mid + 1;
            }
        }

        return minLength;
    }

    public boolean canReducePrefix(int length, String s, int maxOps) {
        int n = s.length();
        final int INF = n + 1;  
        int[][] previous = new int[2][length + 1];  
        int[][] current = new int[2][length + 1];  

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <= length; j++) {
                previous[i][j] = INF;
            }
        }

        int firstChar = s.charAt(0) - '0';
        previous[firstChar][1] = 0;  
        previous[1 - firstChar][1] = 1; 

        for (int i = 1; i < n; i++) {
            for (int c = 0; c < 2; c++) {
                for (int j = 0; j <= length; j++) {
                    current[c][j] = INF;
                }
            }

            int currentChar = s.charAt(i) - '0';
            for (int prevChar = 0; prevChar < 2; prevChar++) {
                for (int level = 1; level <= length; level++) {
                    if (previous[prevChar][level] == INF) continue;  
                    if (currentChar == prevChar) {
                        int nextLevel = level + 1;
                        if (nextLevel <= length) {
                            current[prevChar][nextLevel] = Math.min(current[prevChar][nextLevel], previous[prevChar][level]);
                        }
                    } else {
                        current[currentChar][1] = Math.min(current[currentChar][1], previous[prevChar][level] + 1);
                    }
                    int oppositeChar = 1 - currentChar;
                    if (oppositeChar == prevChar) {
                        int nextLevel = level + 1;
                        if (nextLevel <= length) {
                            current[oppositeChar][nextLevel] = Math.min(current[oppositeChar][nextLevel], previous[prevChar][level] + 1);
                        }
                    } else {
                        current[oppositeChar][1] = Math.min(current[oppositeChar][1], previous[prevChar][level] + 1);
                    }
                }
            }
            for (int j = 0; j < 2; j++) {
                System.arraycopy(current[j], 0, previous[j], 0, length + 1);
            }
        }
        int minOperations = INF;
        for (int c = 0; c < 2; c++) {
            for (int level = 1; level <= length; level++) {
                minOperations = Math.min(minOperations, previous[c][level]);
            }
        }
        return minOperations <= maxOps;
    }
}
