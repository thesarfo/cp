class Solution(object):
    def checkInclusion(self, s1, s2):
        """
        :type s1: str
        :type s2: str
        :rtype: bool
        """
        window = []
        for c in s2:
            window.append(c)
            if len(window) > len(s1):
                window.pop(0)
            if len(window) == len(s1):
                s1_set = set(s1)
                counter = len(s1)
                for c in window:
                    if c in s1_set:
                        counter -= 1
                    else:
                        break
                if counter == 0:
                    return True
        return False