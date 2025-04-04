class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            int value = romanMap.get(s.charAt(i));

            if (i + 1 < length && romanMap.get(s.charAt(i + 1)) > value) {
                total -= value; 
            } else {
                total += value; 
            }
        }

        return total;
    }
}
