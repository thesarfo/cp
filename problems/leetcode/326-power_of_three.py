class Solution:
    def isPowerOfThree(self, n: int) -> bool:
        if n <= 0:
            return False
        while n % 3 == 0:
            n /= 3
        return n == 1


'''We start by checking if the number is zero or negative. If it is, we can't work with it, so we say it's not a power of two.

Now, to check if a number is a power of 3, we keep dividing it by 3 until we can't anymore. 

If we can divide it evenly each time and end up with 1, then it's a power of 3. But if we end up with something other than 1, it's not a power of 3.'''