class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int ALPHA_COUNT = 26;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        long[][] transformMatrix = new long[ALPHA_COUNT][ALPHA_COUNT];

        for (int i = 0; i < ALPHA_COUNT; i++) {
            int steps = nums.get(i);
            for (int j = 0; j < steps; j++) {
                transformMatrix[i][(i + j + 1) % ALPHA_COUNT]++;
            }
        }

        long[] charCounts = new long[ALPHA_COUNT];
        for (char ch : s.toCharArray()) {
            charCounts[ch - 'a']++;
        }

        long[][] finalTransformMatrix = matrixExponentiation(transformMatrix, t);

        long[] resultingCounts = new long[ALPHA_COUNT];
        for (int i = 0; i < ALPHA_COUNT; i++) {
            for (int j = 0; j < ALPHA_COUNT; j++) {
                resultingCounts[j] = (resultingCounts[j] + finalTransformMatrix[i][j] * charCounts[i]) % MOD;
            }
        }

        long totalLength = 0;
        for (long count : resultingCounts) {
            totalLength = (totalLength + count) % MOD;
        }

        return (int) totalLength; 
    }

    private long[][] matrixMultiplication(long[][] matrixA, long[][] matrixB) {
        long[][] productMatrix = new long[ALPHA_COUNT][ALPHA_COUNT];
        for (int i = 0; i < ALPHA_COUNT; i++) {
            for (int j = 0; j < ALPHA_COUNT; j++) {
                productMatrix[i][j] = 0;
                for (int k = 0; k < ALPHA_COUNT; k++) {
                    productMatrix[i][j] = (productMatrix[i][j] + matrixA[i][k] * matrixB[k][j]) % MOD;
                }
            }
        }
        return productMatrix;
    }

    private long[][] matrixExponentiation(long[][] baseMatrix, int exp) {
        long[][] identityMatrix = new long[ALPHA_COUNT][ALPHA_COUNT];
        for (int i = 0; i < ALPHA_COUNT; i++) {
            identityMatrix[i][i] = 1; 
        }
        while (exp > 0) {
            if (exp % 2 == 1) {
                identityMatrix = matrixMultiplication(identityMatrix, baseMatrix);
            }
            baseMatrix = matrixMultiplication(baseMatrix, baseMatrix);
            exp /= 2;
        }
        return identityMatrix;
    }
}