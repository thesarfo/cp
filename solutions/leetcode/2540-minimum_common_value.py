class Solution(object):
    def getCommon(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: int
        """
        ptr1 = 0
        ptr2 = 0

        while ptr1 < len(nums1) and ptr2 < len(nums2):
            if nums1[ptr1] == nums2[ptr2]:
                return nums1[ptr1] 
            elif nums1[ptr1] < nums2[ptr2]:
                ptr1 += 1  
            else:
                ptr2 += 1 
        return -1 