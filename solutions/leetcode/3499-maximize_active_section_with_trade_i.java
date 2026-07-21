class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        String t = "1" + s + "1";
        int n = t.length();
        java.util.List<int[]> runs = new java.util.ArrayList<>();
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && t.charAt(j) == t.charAt(i)) j++;
            runs.add(new int[]{t.charAt(i) - '0', j - i});
            i = j;
        }

        int totalOnes = 0;
        for (int[] r : runs) {
            if (r[0] == 1) totalOnes += r[1];
        }
        totalOnes -= 2;

        int maxGain = 0;
        for (int k = 1; k < runs.size() - 1; k++) {
            if (runs.get(k)[0] == 1) {
                int gain = runs.get(k - 1)[1] + runs.get(k + 1)[1];
                maxGain = Math.max(maxGain, gain);
            }
        }

        return totalOnes + maxGain;
    }
}
