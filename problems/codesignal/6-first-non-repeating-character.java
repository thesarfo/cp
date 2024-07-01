char solution(String s) {
    int[] charCount = new int[26];
    for (char c : s.toCharArray()) {
        charCount[c - 'a']++;
    }

    for (char c : s.toCharArray()) {
        if (charCount[c - 'a'] == 1) {
            return c;
        }
    }
    return '_';
}