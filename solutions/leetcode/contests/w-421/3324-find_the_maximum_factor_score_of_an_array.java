class Solution {
    
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a * (b / gcd(a, b)));
    }

    public long maxScore(int[] nums) {
        int n = nums.length;

        long overallGCD = nums[0];
        long overallLCM = nums[0];

        for (int i = 1; i < n; i++) {
            overallGCD = gcd(overallGCD, nums[i]);
            overallLCM = lcm(overallLCM, nums[i]);
        }

        long maxScore = overallGCD * overallLCM; 

        for (int i = 0; i < n; i++) {
            long currentGCD = 0;
            long currentLCM = 1;

            for (int j = 0; j < n; j++) {
                if (j != i) {
                    currentGCD = (currentGCD == 0) ? nums[j] : gcd(currentGCD, nums[j]);
                    currentLCM = lcm(currentLCM, nums[j]);
                }
            }

            long factorScore = currentGCD * currentLCM;
            maxScore = Math.max(maxScore, factorScore);
        }

        return maxScore;
    }
}
