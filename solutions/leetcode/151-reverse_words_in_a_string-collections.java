class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        List<String> wordList = new ArrayList<>();
        Collections.addAll(wordList, words);
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}