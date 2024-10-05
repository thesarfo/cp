class Solution {
public:
    int minFlips(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        
        int rowFlips = 0;
        for (int i = 0; i < m; ++i) {
            int rowCount = 0;
            for (int j = 0; j < n / 2; ++j) {
                if (grid[i][j] != grid[i][n - 1 - j]) {
                    rowCount++;
                }
            }
            rowFlips += rowCount;
        }
        
        int colFlips = 0;
        for (int j = 0; j < n; ++j) {
            int colCount = 0;
            for (int i = 0; i < m / 2; ++i) {
                if (grid[i][j] != grid[m - 1 - i][j]) {
                    colCount++;
                }
            }
            colFlips += colCount;
        }
        
        return min(rowFlips, colFlips);
    }
};
