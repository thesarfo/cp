class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> mpp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            mpp.put(s.charAt(i), mpp.getOrDefault(s.charAt(i), 0) + 1);
        }

        List<Map.Entry<Character, Integer>> sortedEntries = new ArrayList<>(mpp.entrySet());
        sortedEntries.sort((a, b) -> b.getValue() - a.getValue()); 

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : sortedEntries) {
            result.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }

        return result.toString();
    }
}

