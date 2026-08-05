/*
 * @lc app=leetcode id=1880 lang=java
 *
 * [1880] Check if Word Equals Summation of Two Words
 */

// @lc code=start
class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int fval = Integer.valueOf(calcSum(firstWord));
        int sval = Integer.valueOf(calcSum(secondWord));
        int tval = Integer.valueOf(calcSum(targetWord));

        return (fval + sval) == tval;
    }

    public String calcSum(String word) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            sb.append(word.charAt(i) - 'a');
        }

        return sb.toString();
    }
}
// @lc code=end

