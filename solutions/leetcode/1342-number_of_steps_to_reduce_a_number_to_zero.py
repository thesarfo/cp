class Solution(object):
    def numberOfSteps(self, num):
        """
        :type num: int
        :rtype: int
        """
        steps = 0

        while num > 0:
            if num % 2 == 0:
                num /= 2
            else:
                num -= 1
            steps += 1
        return steps
        