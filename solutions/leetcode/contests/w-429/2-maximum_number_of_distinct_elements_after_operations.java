
class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        int maxValue = Arrays.stream(nums).max().getAsInt();
        int minValue = Arrays.stream(nums).min().getAsInt();

        int range = maxValue - minValue + 1;

        int lastUsedElement = Integer.MIN_VALUE;
        int distinctElementCount = 0;

        int[] frequencyArray = new int[range];

        for (int num : nums) {
            frequencyArray[num - minValue]++;
        }

        for (int i = 0; i < range; ++i) {
            while (frequencyArray[i] > 0) {
                int currentNumber = i + minValue;

                int nextPossibleElement = Math.max(currentNumber - k, lastUsedElement + 1);

                if (nextPossibleElement <= currentNumber + k) {
                    lastUsedElement = nextPossibleElement;
                    distinctElementCount++;
                    frequencyArray[i]--;
                } else {
                    break;
                }
            }
        }
        return distinctElementCount;
    }
}
