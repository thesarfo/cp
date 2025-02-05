class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int parenthesesCount = 0;
      
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i); 
            if (currentChar == '(') {
                if (parenthesesCount > 0) {
                    result.append(currentChar);
                }
                parenthesesCount++;
            } 
            else {
                parenthesesCount--;
                if (parenthesesCount > 0) {
                    result.append(currentChar);
                }
            }
        }
      
        return result.toString();
    }
}
