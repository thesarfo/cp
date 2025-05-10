class Solution {
    public int maxFreqSum(String s) {
        Set<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        
        Map<Character, Integer> vowelFreq = new HashMap<>();
        Map<Character, Integer> consonantFreq = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            if (vowelSet.contains(c)) {
                vowelFreq.put(c, vowelFreq.getOrDefault(c, 0) + 1);
            } else {
                consonantFreq.put(c, consonantFreq.getOrDefault(c, 0) + 1);
            }
        }
        
        int maxVowelFreq = 0;
        for (int freq : vowelFreq.values()) {
            maxVowelFreq = Math.max(maxVowelFreq, freq);
        }
        
        int maxConsonantFreq = 0;
        for (int freq : consonantFreq.values()) {
            maxConsonantFreq = Math.max(maxConsonantFreq, freq);
        }
        
        return maxVowelFreq + maxConsonantFreq;
    }
}