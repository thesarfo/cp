class Solution {
    public int beautySum(String s) {
        int totalBeauty = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            Map<Character, Integer> freq = new HashMap<>();
            
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                freq.put(c, freq.getOrDefault(c, 0) + 1);

                int maxFreq = 0;
                int minFreq = Integer.MAX_VALUE;

                for (int count : freq.values()) {
                    maxFreq = Math.max(maxFreq, count);
                    minFreq = Math.min(minFreq, count);
                }

                totalBeauty += (maxFreq - minFreq);
            }
        }
        
        return totalBeauty;
    }
}   
