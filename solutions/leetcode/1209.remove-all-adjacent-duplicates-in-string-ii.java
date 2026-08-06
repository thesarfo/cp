/*
 * @lc app=leetcode id=1209 lang=java
 *
 * [1209] Remove All Adjacent Duplicates in String II
 */

// @lc code=start
class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<int[]> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek()[0] == c) {
                stack.peek()[1]++;

                if (stack.peek()[1] == k) {
                    stack.pop();
                }
            } else {
                stack.push(new int[]{c, 1});
            }

        }

        StringBuilder sb = new StringBuilder();
        for (int[] arr : stack) {
            char c = (char) arr[0];

            int count = arr[1];

            for(int i = 0; i < count; i++){
                sb.append(c);
            }
        }

        return sb.reverse().toString();
    }
}
// @lc code=end

