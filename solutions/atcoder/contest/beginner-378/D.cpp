#include <iostream>
#include <vector>
#include <set>
using namespace std;

int H, W, K;
vector<string> grid;
int pathCount = 0;

int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};

void dfs(int x, int y, int steps, set<pair<int, int>>& visited) {
    if (steps == K) {
        pathCount++;
        return;
    }
    
    for (int d = 0; d < 4; d++) {
        int nx = x + dx[d];
        int ny = y + dy[d];
        
        
        if (nx >= 0 && nx < H && ny >= 0 && ny < W && grid[nx][ny] == '.' && !visited.count({nx, ny})) {
            visited.insert({nx, ny});  
            dfs(nx, ny, steps + 1, visited);
            visited.erase({nx, ny});
        }
    }
}

int main() {
    cin >> H >> W >> K;
    grid.resize(H);

    for (int i = 0; i < H; i++) {
        cin >> grid[i];
    }

    for (int i = 0; i < H; i++) {
        for (int j = 0; j < W; j++) {
            if (grid[i][j] == '.') {
                set<pair<int, int>> visited;
                visited.insert({i, j});
                dfs(i, j, 0, visited);
            }
        }
    }

    cout << pathCount << endl;
    return 0;
}
