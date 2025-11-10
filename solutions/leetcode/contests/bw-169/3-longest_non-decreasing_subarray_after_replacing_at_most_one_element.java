import java.util.ArrayDeque;

class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int maxLen = 1, left = 0;
        ArrayDeque<Integer> dec = new ArrayDeque<>();

        for (int right = 0; right < n; right++) {
            if (right > 0 && nums[right - 1] > nums[right]) dec.addLast(right - 1);

            while (!dec.isEmpty() && dec.peekFirst() < left) dec.pollFirst();

            while (!dec.isEmpty() && dec.size() == 1) {
                int h = dec.peekFirst();
                boolean canReplace = (h == left || nums[h - 1] <= nums[h + 1]) ||
                                     (h + 1 == right || nums[h] <= nums[h + 2]);
                if (canReplace) break;
                left++;
                while (!dec.isEmpty() && dec.peekFirst() < left) dec.pollFirst();
            }

            if (dec.size() > 1) {
                while (dec.size() > 1) {
                    left++;
                    while (!dec.isEmpty() && dec.peekFirst() < left) dec.pollFirst();
                }
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
