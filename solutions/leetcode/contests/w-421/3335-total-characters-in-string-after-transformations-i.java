class Solution {
    public int lengthAfterTransformations(String input, int transformations) {
        final int MOD = 1_000_000_007; 
        long[] charCounts = new long[26];

        for (char c : input.toCharArray()) {
            charCounts[c - 'a']++;
        }

        for (int t = 0; t < transformations; t++) {
            long[] updatedCounts = new long[26];
            for (int i = 0; i < 26; i++) {
                if (charCounts[i] > 0) {
                    if (i == 25) { 
                        updatedCounts[0] = (updatedCounts[0] + charCounts[i]) % MOD; 
                        updatedCounts[1] = (updatedCounts[1] + charCounts[i]) % MOD; 
                    } else { 
                        updatedCounts[i + 1] = (updatedCounts[i + 1] + charCounts[i]) % MOD;
                    }
                }
            }
            charCounts = updatedCounts; 
        }

        long finalLength = 0;
        for (long count : charCounts) {
            finalLength = (finalLength + count) % MOD;
        }
        
        return (int) finalLength; 
    }
}
