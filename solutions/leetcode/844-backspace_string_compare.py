class Solution(object):
    def backspaceCompare(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        def build_string(s):
            result = []
            backspace_count = 0
            for char in reversed(s):
                if char == '#':
                    backspace_count += 1
                elif backspace_count > 0:
                    backspace_count -= 1
                else:
                    result.append(char)
            return ''.join(result)
        
        return build_string(s) == build_string(t)