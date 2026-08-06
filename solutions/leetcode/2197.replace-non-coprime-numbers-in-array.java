/*
 * @lc app=leetcode id=2197 lang=java
 *
 * [2197] Replace Non-Coprime Numbers in Array
 */

// @lc code=start
class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Deque<Long> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            long currentnum = num;

            while (!stack.isEmpty()) {
                long top = stack.peek();
                long gcd = findgcd(currentnum, top);

                if (gcd > 1) {
                    stack.pop();

                    currentnum = findlcm(currentnum, top);
                } else {
                    break;
                }
            }
            stack.push(currentnum);

        }

        while (!stack.isEmpty()) {
            list.add(stack.pop().intValue());
        }

        Collections.reverse(list);

        return list;
    }

    public static long findlcm(long a, long b) {
        if (a == 0 || b == 0)
            return 0;
        return Math.abs((a / findgcd(a, b)) * b);
    }

    public static long findgcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return findgcd(b, a % b);
    }
}
// @lc code=end

