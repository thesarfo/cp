class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        trust_count = [0] * (n + 1) 
        trusted_by_count = [0] * (n + 1) 
        
        for a, b in trust:
            trust_count[b] += 1
            trusted_by_count[a] += 1
        
        for i in range(1, n + 1):
            if trust_count[i] == n - 1 and trusted_by_count[i] == 0:
                return i  
        
        return -1  