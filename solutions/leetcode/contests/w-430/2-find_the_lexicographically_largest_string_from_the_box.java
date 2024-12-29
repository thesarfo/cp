import java.util.*;

class Solution {
    public String answerString(String word, int numFriends) {
        int N = word.length();
        if (numFriends == 1) return word;

        char c = Collections.max(word.chars().mapToObj(e -> (char) e).toList());
        String maxString = "";

        for (int pos = 0; pos < N; pos++) {
            if (word.charAt(pos) == c) {
                int lAllowed = Math.min(N - pos, N - numFriends + 1);
                if (lAllowed <= 0) continue;

                String s = word.substring(pos, pos + lAllowed);
                if (s.compareTo(maxString) > 0) {
                    maxString = s;
                }
            }
        }

        return maxString;
    }
}
