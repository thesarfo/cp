class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        
        if (index != -1) {
            String toReverse = word.substring(0, index + 1);
            StringBuilder reversed = new StringBuilder(toReverse);
            reversed.reverse();
            return reversed.toString() + word.substring(index + 1);
        } else {
            return word;
        }
        

    }
}