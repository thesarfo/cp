class Solution(object):
    def goodDaysToRobBank(self, security, time):
        def is_good_day(security, time, i):
            for j in range(i - time, i):
                if j < 0 or security[j] < security[j + 1]:
                    return False
            for j in range(i + 1, i + time + 1):
                if j >= len(security) or security[j] > security[j - 1]:
                    return False
            return True
        
        good_days = []
        for i in range(len(security)):
            if is_good_day(security, time, i):
                good_days.append(i)
        
        return good_days

# Test cases
solution = Solution()
security1 = [5, 3, 3, 3, 5, 6, 2]
time1 = 2
print(solution.goodDaysToRobBank(security1, time1))  # Output: [2, 3]

security2 = [1, 1, 1, 1, 1]
time2 = 0
print(solution.goodDaysToRobBank(security2, time2))  # Output: [0, 1, 2, 3, 4]

security3 = [1, 2, 3, 4, 5, 6]
time3 = 2
print(solution.goodDaysToRobBank(security3, time3))  # Output: []
