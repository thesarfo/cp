class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        s = s.strip()
    
        words = s.split()
        
        if words:
            return len(words[-1])
        else:
            return 0