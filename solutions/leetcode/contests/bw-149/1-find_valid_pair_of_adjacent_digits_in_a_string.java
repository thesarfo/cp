class Solution {
    public String findValidPair(String s) {
        int[] digitCount = new int[10];
        
        for (char digit : s.toCharArray()) {
            digitCount[digit - '0']++;
        }
        
        for (int index = 0; index < s.length() - 1; index++) {
            int firstDigit = s.charAt(index) - '0';
            int secondDigit = s.charAt(index + 1) - '0';
            
            if (firstDigit != secondDigit) {
                if (digitCount[firstDigit] == firstDigit && digitCount[secondDigit] == secondDigit) {
                    return s.substring(index, index + 2);
                }
            }
        }
        
        return "";
    }
}
