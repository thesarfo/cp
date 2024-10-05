int solution(String word) {
    Map<Character, Integer> charCount = new HashMap<>();
    
    for (char c : word.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        int oddCount = 0;
        for (int count : charCount.values()) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        return Math.max(0, oddCount - 1);

}