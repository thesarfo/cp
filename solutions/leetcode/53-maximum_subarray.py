class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max_so_far = nums[0]
        current_sum = 0

        for i in nums:
            if current_sum < 0:
                current_sum = 0
            
            current_sum += i
            max_so_far = max(max_so_far, current_sum)
        
        return max_so_far