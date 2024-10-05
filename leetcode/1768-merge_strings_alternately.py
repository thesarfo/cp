class Solution(object):
    def mergeAlternately(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: str
        """
        final_array = []
        len1, len2 = len(word1), len(word2)
        max_len = max(len1, len2)
        
        for i in range(max_len):
            if i < len1:
                final_array.append(word1[i])
            if i < len2:
                final_array.append(word2[i])
        
        return ''.join(final_array)