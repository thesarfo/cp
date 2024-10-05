class Solution:
    def customSortString(self, order, s):
        words = [0] * 26
        result = ''

        for w in s:
            words[ord(w) - ord('a')] += 1

        for w in order:
            ch = ord(w) - ord('a')
            result += w * words[ch]
            words[ch] = 0

        for i, count in enumerate(words):
            w = chr(i + ord('a'))
            if count > 0:
                result += w * count

        return result 