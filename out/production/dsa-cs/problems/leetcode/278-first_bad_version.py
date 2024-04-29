# The isBadVersion API is already defined for you.
# def isBadVersion(version: int) -> bool:

class Solution:
    def firstBadVersion(self, n: int) -> int:
        l, r = 1, n

        while l <= r:
            m = (l + r) // 2
            res = isBadVersion(m)

            if res:
                r = m - 1
            else:
                l = m + 1
        return l