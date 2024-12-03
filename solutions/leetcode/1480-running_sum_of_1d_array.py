class Solution(object):
    def runningSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        sum = 0
        nnums = []

        for num in nums:
            sum += num
            nnums.append(sum)

        return nnums
        