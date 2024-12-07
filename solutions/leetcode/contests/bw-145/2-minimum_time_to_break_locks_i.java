import java.util.Arrays;
import java.util.List;

class Solution {
    long[][] mm;
    int n;
    int P;
    List<Integer> strength;

    public long dp(int mxk, int erx) {
        if (mxk == (1 << n) - 1) {
            return 0;
        }

        if (mm[mxk][erx] != -1) {
            return mm[mxk][erx];
        }

        long r = Long.MAX_VALUE;

        for (int i = 0; i < n; ++i) {
            if ((mxk & (1 << i)) == 0) {
                long t = (long) Math.ceil((double) strength.get(i) / erx);

                int nx = erx + P;

                long tt = t + dp(mxk | (1 << i), nx);

                r = Math.min(r, tt);
            }
        }

        return mm[mxk][erx] = r;
    }

    public int findMinimumTime(List<Integer> strength, int P) {
        this.strength = strength;
        this.P = P;
        this.n = strength.size();

        mm = new long[1 << n][100];
        for (int i = 0; i < (1 << n); ++i) {
            Arrays.fill(mm[i], -1);
        }

        long awr = dp(0, 1);

        return (awr <= 1e12) ? (int) awr : -1;
    }
}