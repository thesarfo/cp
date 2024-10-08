class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> s_count = new HashMap<>();
        HashMap<Character, Integer> t_count = new HashMap<>();

        for (char c : s.toCharArray()) {
            s_count.put(c, s_count.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            t_count.put(c, t_count.getOrDefault(c, 0) + 1);
        }

        return s_count.equals(t_count);
    }
}
