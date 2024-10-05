class Solution {
    public String stringHash(String s, int k) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < s.length(); i += k) {
            String substring = s.substring(i, i + k);
            int sum = 0;
            
            for (char c : substring.toCharArray()) {
                sum += (c - 'a'); 
            }
            
            int hashedChar = sum % 26;
            
            result.append((char) (hashedChar + 'a'));
        }
        
        return result.toString();
    }
}
