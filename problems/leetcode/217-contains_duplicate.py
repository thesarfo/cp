class Solution(object):
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        count = 0
        for i in nums:
            if i == i:
                count += 1
        if count < 1:
            return False
        else:
            return True