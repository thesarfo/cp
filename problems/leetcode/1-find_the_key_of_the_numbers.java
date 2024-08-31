class Solution {
    public int generateKey(int num1, int num2, int num3) {
        String first = String.format("%04d", num1);
        String second = String.format("%04d", num2);
        String third = String.format("%04d", num3);
        
        StringBuilder key = new StringBuilder();
        
        for (int i = 0; i < 4; i++) {
            char c1 = first.charAt(i);
            char c2 = second.charAt(i);
            char c3 = third.charAt(i);
            
            char minDigit = (char) Math.min(c1, Math.min(c2, c3));
            
            key.append(minDigit);
        }
        
        return Integer.parseInt(key.toString());
    }
}
