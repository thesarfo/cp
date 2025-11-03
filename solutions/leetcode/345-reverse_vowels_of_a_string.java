class Solution {
    public String reverseVowels(String s) {
        char[] sa = s.toCharArray();
        int l = 0, r = sa.length - 1;

        Set<Character> vowelSet = new HashSet<>();
        for (char v : new char[] { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' }) {
            vowelSet.add(v);
        }

        while (l <= r) {
            if (vowelSet.contains(sa[l]) && vowelSet.contains(sa[r])) {
                char temp = sa[l];
                sa[l] = sa[r];
                sa[r] = temp;
                l++;
                r--;
            } else if (vowelSet.contains(sa[l]) && !vowelSet.contains(sa[r])) {
                r--;
            } else {
                l++;
            }

        }

        String res = new String(sa);
        return res;
    }
}