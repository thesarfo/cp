class Solution(object):
    def compressedString(self, word):
        """
        :type word: str
        :rtype: str
        """
        comp = ""
        i = 0
        n = len(word)
        
        while i < n:
            c = word[i]
            count = 0
            while i < n and word[i] == c and count < 9:
                count += 1
                i += 1
            comp += str(count) + c
        
        return comp