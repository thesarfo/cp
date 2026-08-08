/*
 * @lc app=leetcode id=3302 lang=cpp
 *
 * [3302] Find the Lexicographically Smallest Valid Sequence
 */

// @lc code=start
class Solution {
public:
    vector<int> validSequence(string word1, string word2) {
        int n = word1.size(), m = word2.size();
        if (m > n) return {};

        vector<int> suf(m + 1);
        suf[m] = n;
        int p = n;
        for (int j = m - 1; j >= 0; --j) {
            p = min(p, suf[j + 1]) - 1;
            while (p >= 0 && word1[p] != word2[j]) --p;
            suf[j] = p;
        }

        vector<int> result;
        result.reserve(m);
        bool usedChange = false;
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (word1[i] == word2[j]) {
                result.push_back(i);
                ++i; ++j;
            } else if (!usedChange && suf[j + 1] >= i + 1) {
                usedChange = true;
                result.push_back(i);
                ++i; ++j;
            } else {
                ++i;
            }
        }

        if (j < m) return {};
        return result;
    }
};
// @lc code=end

