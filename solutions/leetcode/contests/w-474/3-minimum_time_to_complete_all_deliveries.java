class Solution {
    public long minimumTime(int[] d, int[] r) {
        long[] deliveries = {d[0], d[1]};

        long l = deliveries[0] + deliveries[1];
        long h = l * Math.max(r[0], r[1]);

        while (l < h) {
            long m = (l + h) / 2;

            long w1 = m - m / r[0];
            long w2 = m - m / r[1];
            long lcm = r[0] * (long) r[1] / gcd(r[0], r[1]);
            long a = m - m / lcm;

            if (deliveries[0] <= w1 && deliveries[1] <= w2 && deliveries[0] + deliveries[1] <= a) {
                h = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

        private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
