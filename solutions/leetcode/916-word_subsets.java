class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();
        
        int[] maxFreq = new int[26];
        for (String b : words2) {
            int[] freq = countFrequency(b);
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }
        }
        
        for (String a : words1) {
            int[] freqA = countFrequency(a);
            if (isUniversal(freqA, maxFreq)) {
                res.add(a);
            }
        }
        
        return res;
    }
    
    private int[] countFrequency(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }
    
    private boolean isUniversal(int[] freqA, int[] maxFreq) {
        for (int i = 0; i < 26; i++) {
            if (freqA[i] < maxFreq[i]) {
                return false;
            }
        }
        return true;
    }
}
