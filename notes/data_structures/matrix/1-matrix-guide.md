A matrix is just a grid of elements. Think of it as `grid[row][col]` instead of a flat list.

## The 5 Things That Matter

### 1. Basics

```java
grid.length        // number of rows
grid[0].length     // number of columns
grid[r][c]         // element at row r, column c
```

### 2. Nested traversal (visits every cell)

```java
for (int r = 0; r < grid.length; r++) {
    for (int c = 0; c < grid[0].length; c++) {
        // do something with grid[r][c]
    }
}
```

This alone solves easy problems like Transpose Matrix (867) and Reshape Matrix (566).

### 3. Direction arrays (exploring up/down/left/right)

Instead of writing the four moves by hand every time:

```java
int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}}; // up, down, left, right

for (int[] d : dirs) {
    int nr = r + d[0];
    int nc = c + d[1];
    if (nr < 0 || nc < 0 || nr >= rows || nc >= cols) continue; // bounds check
    // visit grid[nr][nc]
}
```

This is the heart of almost every graph-on-grid problem (Number of Islands, Flood Fill, Word Search).

### 4. Visiting cells (don't revisit)

Either use a `boolean[][] visited` array, or overwrite the grid itself to mark a cell as seen.

### 5. DFS vs BFS

- **DFS (recursive):** explore one branch fully, then backtrack. Use for: Number of Islands, Flood Fill.
- **BFS (queue, level by level):** counts steps/shortest paths. Use for: Rotting Oranges, 01 Matrix, Shortest Path in Binary Matrix.
- **Multi-source BFS:** push every starting cell into the queue at once and spread together (all rotten oranges at the same time).
- **Backtracking:** DFS where you also *undo* after exploring: `visited[r][c] = true; dfs(...); visited[r][c] = false;`. Use for: Word Search, Sudoku, N-Queens.

## Pattern Recognition Cheat Sheet

Ask yourself one question and the approach falls out:

| If you are... | Use |
|---|---|
| visiting every cell once | nested loops |
| exploring neighbors | DFS / BFS |
| following movement rules | simulation (Spiral Matrix, Rotate Image) |
| finding shortest steps | BFS |
| maximizing/minimizing | DP (Unique Paths, Min Path Sum, Maximal Square) |
| trying every path | backtracking |
| summing rectangles fast | prefix sum matrix |

## Practice Roadmap (stages, in order)

1. **Traversal:** [1920](https://leetcode.com/problems/build-array-from-permutation/), [867](https://leetcode.com/problems/transpose-matrix/), [566](https://leetcode.com/problems/reshape-the-matrix/), [1572](https://leetcode.com/problems/matrix-diagonal-sum/), [2639](https://leetcode.com/problems/find-the-width-of-columns-of-a-grid/)
2. **Simulation:** [54 Spiral Matrix](https://leetcode.com/problems/spiral-matrix/), [59](https://leetcode.com/problems/spiral-matrix-ii/), [48 Rotate Image](https://leetcode.com/problems/rotate-image/), [73 Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes/), [289 Game of Life](https://leetcode.com/problems/game-of-life/)
3. **DFS:** [733 Flood Fill](https://leetcode.com/problems/flood-fill/), [200 Number of Islands](https://leetcode.com/problems/number-of-islands/), [695 Max Area of Island](https://leetcode.com/problems/max-area-of-island/), [463](https://leetcode.com/problems/island-perimeter/), [130 Surrounded Regions](https://leetcode.com/problems/surrounded-regions/)
4. **BFS:** [994 Rotting Oranges](https://leetcode.com/problems/rotting-oranges/), [542 01 Matrix](https://leetcode.com/problems/01-matrix/), [286 Walls and Gates](https://leetcode.com/problems/walls-and-gates/), [1091 Shortest Path in Binary Matrix](https://leetcode.com/problems/shortest-path-in-binary-matrix/)
5. **Backtracking:** [79 Word Search](https://leetcode.com/problems/word-search/), [212 Word Search II](https://leetcode.com/problems/word-search-ii/), [37 Sudoku Solver](https://leetcode.com/problems/sudoku-solver/)
6. **Matrix DP:** [62 Unique Paths](https://leetcode.com/problems/unique-paths/), [64 Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/), [221 Maximal Square](https://leetcode.com/problems/maximal-square/), [329 Longest Increasing Path](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/)
7. **Hard:** [827](https://leetcode.com/problems/making-a-large-island/), [980](https://leetcode.com/problems/unique-paths-iii/), [317](https://leetcode.com/problems/shortest-distance-from-all-buildings/), [778](https://leetcode.com/problems/swim-in-rising-water/), [407](https://leetcode.com/problems/trapping-rain-water-ii/)

## Must-Know Before an Interview

If you can solve these without help you are in good shape:

[867](https://leetcode.com/problems/transpose-matrix/), [1572](https://leetcode.com/problems/matrix-diagonal-sum/), [54](https://leetcode.com/problems/spiral-matrix/), [48](https://leetcode.com/problems/rotate-image/), [733](https://leetcode.com/problems/flood-fill/), [200](https://leetcode.com/problems/number-of-islands/), [695](https://leetcode.com/problems/max-area-of-island/), [994](https://leetcode.com/problems/rotting-oranges/), [542](https://leetcode.com/problems/01-matrix/), [79](https://leetcode.com/problems/word-search/), [62](https://leetcode.com/problems/unique-paths/), [64](https://leetcode.com/problems/minimum-path-sum/)

## The One Piece of Advice

Don't treat "2D arrays" as a single topic. Treat the matrix as a *setting* where algorithms you already know run. Once nested traversal, direction arrays, bounds checks, DFS/BFS, simulation, and DP feel mechanical, the only hard part left is recognizing which pattern the problem is asking for.
