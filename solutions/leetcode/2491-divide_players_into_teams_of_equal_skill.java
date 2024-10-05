import java.util.Arrays;

class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        
        int n = skill.length;
        long totalSkill = 0;
        
        for (int s : skill) {
            totalSkill += s;
        }
        
        int teamCount = n / 2;
        if (totalSkill % teamCount != 0) {
            return -1; 
        }
        
        long targetSkill = totalSkill / teamCount;
        long totalChemistry = 0;
        
        for (int i = 0; i < teamCount; i++) {
            int left = skill[i];  
            int right = skill[n - 1 - i];  
            
            if (left + right != targetSkill) {
                return -1;  
            }
            
            totalChemistry += (long) left * right;
        }
        
        return totalChemistry; 
    }
}
