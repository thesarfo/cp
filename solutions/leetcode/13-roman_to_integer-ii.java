class Solution {
    public int romanToInt(String s) {
        String cs = "IVXLCDM";
        int[] vs = {1, 5, 10, 50, 100, 500, 1000};

        Map<Character, Integer> romanToValue = new HashMap<>();
        for (int i = 0; i < vs.length; ++i) {
            romanToValue.put(cs.charAt(i), vs[i]);
        }

        int n = s.length();

        int result = romanToValue.get(s.charAt(n - 1));

        for (int i = 0; i < n - 1; ++i) {
            int current = romanToValue.get(s.charAt(i));
            int next = romanToValue.get(s.charAt(i + 1));

            if (current < next) {
                result -= current;
            } else {
                result += current;
            }
        }

        return result;
    }
}
