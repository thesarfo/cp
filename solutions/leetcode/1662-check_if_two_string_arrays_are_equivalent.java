class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder firstString = new StringBuilder();
        StringBuilder secondString = new StringBuilder();

        for (String word : word1) {
            firstString.append(word);
        }

        for (String word : word2) {
            secondString.append(word);
        }

        return firstString.toString().equals(secondString.toString());
    }
}
