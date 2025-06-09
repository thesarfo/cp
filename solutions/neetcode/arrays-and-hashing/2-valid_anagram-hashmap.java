class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> smp = new HashMap<>();
        HashMap<Character, Integer> tmp = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            smp.put(s.charAt(i), smp.getOrDefault(s.charAt(i), 0) + 1);
            tmp.put(t.charAt(i), tmp.getOrDefault(t.charAt(i), 0) + 1);
        }

        return smp.equals(tmp);
    }
}

