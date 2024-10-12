class Solution:
    def findWinningPlayer(self, skills, k):
        n = len(skills)
        
        if k >= n:
            return skills.index(max(skills))
        
        max_skill = max(skills)
        max_index = skills.index(max_skill)
        
        current_champion = skills[0]
        consecutive_wins = 0
        
        for i in range(1, n):
            if skills[i] > current_champion:
                current_champion = skills[i]
                consecutive_wins = 1
            else:
                consecutive_wins += 1
            
            if consecutive_wins == k:
                return skills.index(current_champion)
        
        return max_index