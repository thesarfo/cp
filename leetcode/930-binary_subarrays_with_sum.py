class Solution(object):
    def numSubarraysWithSum(self, nums, goal):
        """
        :type nums: List[int]
        :type goal: int
        :rtype: int
        """
        l1 = l2 = sum1 = sum2 = idx = all_subarrays = 0

        array_length = len(nums)

        while idx < array_length:
            sum1 += nums[idx]
            sum2 += nums[idx]

            while l1 <= idx and sum1 > goal:
                sum1 -= nums[l1]
                l1 += 1

            while l2 <= idx and sum2 >= goal:
                sum2 -= nums[l2]
                l2 += 1

            all_subarrays += l2 - l1

            idx += 1

        return all_subarrays