import java.util.HashMap;
import java.util.Map;

class Solution {
    private long modularExponentiation(long base, long exponent, long modulus) {
        long result = 1; base %= modulus;
        while (exponent > 0) {
            if ((exponent & 1) == 1) result = (result * base) % modulus;
            base = (base * base) % modulus; exponent >>= 1;
        }
        return result;
    }
    public long countSubstrings(String input) {
        int length = input.length(), prefixMod3[] = new int[length + 1], prefixMod9[] = new int[length + 1], prefixMod7[] = new int[length + 1], powerMod7[] = new int[length + 1], inversePowerMod7[] = new int[length + 1], quotientMod7[] = new int[length + 1];
        prefixMod3[0] = prefixMod9[0] = prefixMod7[0] = powerMod7[0] = 1;
        for (int i = 0; i < length; i++) {
            int digit = input.charAt(i) - '0';
            prefixMod3[i + 1] = (prefixMod3[i] + digit) % 3; prefixMod9[i + 1] = (prefixMod9[i] + digit) % 9;
            prefixMod7[i + 1] = (prefixMod7[i] * 10 + digit) % 7;
            if (i < length) powerMod7[i + 1] = (powerMod7[i] * 10) % 7;
        }
        for (int i = 0; i <= length; i++) inversePowerMod7[i] = (int) modularExponentiation(powerMod7[i], 5, 7);
        for (int i = 0; i <= length; i++) quotientMod7[i] = (prefixMod7[i] * inversePowerMod7[i]) % 7;
        Map<Integer, Integer> frequencyMod3 = new HashMap<>(), frequencyMod9 = new HashMap<>(), frequencyMod7 = new HashMap<>();
        long totalCount = 0;
        for (int j = 0; j < length; j++) {
            int digit = input.charAt(j) - '0';
            long contribution = switch (digit) {
                case 0 -> 0;
                case 1, 2, 5 -> 1 + j;
                case 3, 6 -> 1 + frequencyMod3.getOrDefault(prefixMod3[j], 0);
                case 9 -> 1 + frequencyMod9.getOrDefault(prefixMod9[j], 0);
                case 4 -> (j >= 1 && (input.charAt(j - 1) - '0') % 2 == 0) ? 1 + j : 1;
                case 7 -> 1 + frequencyMod7.getOrDefault(quotientMod7[j], 0);
                case 8 -> {
                    long multiple = 0;
                    if (j > 0 && (input.charAt(j - 1) - '0') % 4 == 0) multiple++;
                    if (j > 1 && ((input.charAt(j - 2) - '0') * 10 + (input.charAt(j - 1) - '0')) % 4 == 0) multiple += (j - 1);
                    yield 1 + multiple;
                }
                default -> 0;
            };
            totalCount += contribution;
            frequencyMod3.put(prefixMod3[j], frequencyMod3.getOrDefault(prefixMod3[j], 0) + 1);
            frequencyMod9.put(prefixMod9[j], frequencyMod9.getOrDefault(prefixMod9[j], 0) + 1);
            frequencyMod7.put(quotientMod7[j], frequencyMod7.getOrDefault(quotientMod7[j], 0) + 1);
        }
        return totalCount;
    }
}

