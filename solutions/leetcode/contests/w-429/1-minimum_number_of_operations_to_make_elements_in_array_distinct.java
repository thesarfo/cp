import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minimumOperations(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int duplicateCount = 0;
        for (int frequency : frequencyMap.values()) {
            if (frequency > 1) {
                duplicateCount += frequency - 1;
            }
        }

        int operationsCount = 0;
        while (duplicateCount > 0) {
            if (nums.length >= 3) {
                nums = java.util.Arrays.copyOfRange(nums, 3, nums.length); 
            } else {
                nums = new int[0];
            }

            frequencyMap.clear();
            for (int num : nums) {
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            }

            duplicateCount = 0;
            for (int frequency : frequencyMap.values()) {
                if (frequency > 1) {
                    duplicateCount += frequency - 1;
                }
            }

            operationsCount++;
        }

        return operationsCount;
    }
}
