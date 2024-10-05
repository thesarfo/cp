
class Solution:
    def pivotInteger(self, n):
        if n == 1:
            return 1

        total_sum = 0
        for i in range(1, n + 1):
            total_sum += i

        current_sum = 0
  
        for i in range(1, n + 1):
            current_sum += i
            if current_sum == total_sum:
                return i
            total_sum -= i

        return -1