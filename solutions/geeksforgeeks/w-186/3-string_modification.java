class Solution {
    private int getMinShifts(char from, char to) {
        int difference = Math.abs(from - to);
        return Math.min(difference, 26 - difference);
    }
    
    public String findSmallest(String s, int k) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int totalPairs = length / 2;
        
        int[] minShiftsPerPair = new int[totalPairs];
        for (int i = 0; i < totalPairs; i++) {
            minShiftsPerPair[i] = getMinShifts(chars[i], chars[length - 1 
- i]);
        }
        
        int totalMinShifts = 0;
        for (int shifts : minShiftsPerPair) {
            totalMinShifts += shifts;
        }
        if (totalMinShifts > k) return "";
        
        int[] suffixMinShifts = new int[totalPairs + 1];
        for (int i = totalPairs - 1; i >= 0; i--) {
            suffixMinShifts[i] = suffixMinShifts[i + 1] + 
minShiftsPerPair[i];
        }
        
        int shiftsUsed = 0;
        for (int i = 0; i < totalPairs; i++) {
            char leftChar = chars[i];
            char rightChar = chars[length - 1 - i];
            
            for (char c = 'a'; c <= 'z'; c++) {
                int neededShifts = getMinShifts(leftChar, c) + 
getMinShifts(rightChar, c);
                if (shiftsUsed + neededShifts + suffixMinShifts[i + 1] <= 
k) {
                    chars[i] = chars[length - 1 - i] = c;
                    shiftsUsed += neededShifts;
                    break;
                }
            }
        }
        
        if (length % 2 == 1) {
            int midIndex = length / 2;
            for (char c = 'a'; c <= 'z'; c++) {
                int neededShifts = getMinShifts(chars[midIndex], c);
                if (shiftsUsed + neededShifts <= k) {
                    chars[midIndex] = c;
                    shiftsUsed += neededShifts;
                    break;
                }
            }
        }
        
        return new String(chars);
    }
}
