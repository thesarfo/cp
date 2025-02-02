import java.util.*;

class Solution {
    public int maxDifference(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        List<Integer> oddFrequencies = new ArrayList<>();
        List<Integer> evenFrequencies = new ArrayList<>();
        
        for (int frequency : frequencyMap.values()) {
            if (frequency % 2 == 0) {
                evenFrequencies.add(frequency);
            } else {
                oddFrequencies.add(frequency);
            }
        }
        
        return Collections.max(oddFrequencies) - Collections.min(evenFrequencies);
    }
}
