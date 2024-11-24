class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        int n = s.length();

        int sl = n / k;

        if (n % k != 0) {
            return false;
        }

        String[] sts = new String[k];
        String[] stt = new String[k];

        for (int i = 0; i < k; i++) {
            sts[i] = s.substring(i * sl, (i + 1) * sl);
            stt[i] = t.substring(i * sl, (i + 1) * sl);
        }

        Arrays.sort(sts);
        Arrays.sort(stt);

        return Arrays.equals(sts, stt);
    }
}