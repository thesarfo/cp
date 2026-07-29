class Solution {
    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) cnt[s.charAt(i) - 'a']++;

        int[] half = new int[26];
        int oddChar = -1;
        for (int i = 0; i < 26; i++) {
            half[i] = cnt[i] / 2;
            if ((cnt[i] & 1) == 1) oddChar = i;
        }
        int m = 0;
        for (int i = 0; i < 26; i++) m += half[i];

        final long CAP = 2_000_000L;

        long total = multinomialCapped(half, CAP);
        if (total < k) return "";

        long kk = k;
        int[] remaining = half.clone();
        int remLen = m;
        StringBuilder sb = new StringBuilder();

        for (int pos = 0; pos < m; pos++) {
            for (int c = 0; c < 26; c++) {
                if (remaining[c] == 0) continue;
                remaining[c]--;
                long cntPerms = multinomialCapped(remaining, CAP);
                if (kk <= cntPerms) {
                    sb.append((char) ('a' + c));
                    remLen--;
                    break;
                } else {
                    kk -= cntPerms;
                    remaining[c]++;
                }
            }
        }

        String halfStr = sb.toString();
        StringBuilder result = new StringBuilder();
        result.append(halfStr);
        if (oddChar != -1) result.append((char) ('a' + oddChar));
        result.append(new StringBuilder(halfStr).reverse());
        return result.toString();
    }

    private long multinomialCapped(int[] counts, long cap) {
        long result = 1;
        long remaining = 0;
        for (int c = 0; c < 26; c++) {
            int cc = counts[c];
            for (int j = 1; j <= cc; j++) {
                remaining++;
                result = result * remaining / j;
                if (result > cap) return cap + 1;
            }
        }
        return result;
    }
}
