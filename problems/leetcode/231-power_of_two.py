class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        if n <= 0:
            return False
        while n % 2 == 0:
            n /= 2
        return n == 1


'''We start by checking if the number is zero or negative. If it is, we can't work with it, so we say it's not a power of two.

Now, to check if a number is a power of two, we keep dividing it by 2 until we can't anymore. 

If we can divide it evenly each time and end up with 1, then it's a power of two. But if we end up with something other than 1, it's not a power of two.'''
