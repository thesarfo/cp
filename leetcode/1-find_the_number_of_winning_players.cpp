class Solution {
public:
    int winningPlayerCount(int n, vector<vector<int>>& pick) {
        vector<unordered_map<int, int>> playerCounts(n);
        
        for (const auto& p : pick) {
            int player = p[0];
            int color = p[1];
            playerCounts[player][color]++;
        }
        
        int winningPlayers = 0;
        
        for (int i = 0; i < n; ++i) {
            for (const auto& count : playerCounts[i]) {
                if (count.second >= i + 1) {
                    winningPlayers++;
                    break;
                }
            }
        }
        
        return winningPlayers;
    }
};