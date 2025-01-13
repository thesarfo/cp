class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> lowerSet = new HashSet<>();
        Set<Character> upperSet = new HashSet<>();
        
        for (char c : word.toCharArray()) {
            if (Character.isLowerCase(c)) lowerSet.add(c);
            else if (Character.isUpperCase(c)) upperSet.add(c);
        }
        
        int specialLettersCount = 0;
        for (char c : lowerSet) {
            if (upperSet.contains(Character.toUpperCase(c))) specialLettersCount++;
        }
        return specialLettersCount;
    }
}
