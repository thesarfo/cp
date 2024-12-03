class Solution(object):
    def findMin(self, nums):
        low, high = 0, len(nums) - 1

        while low < high:
            mid = (low + high) // 2

            if nums[mid] == nums[high]:
                high -= 1
            elif nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid
        
        return nums[low]
