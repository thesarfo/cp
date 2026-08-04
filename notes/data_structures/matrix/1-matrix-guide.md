# Matrices (2D Arrays): Study Guide

A matrix is just a grid of elements arranged in rows and columns. The core mental shift: stop thinking in one list and think in **coordinates**: every element lives at a position `(row, col)`.

Matrix problems feel hard because they combine patterns you already know (arrays, graphs, DP). But there are only a handful of recurring techniques. Learn those, and you can recognize and solve most matrix problems mechanically.

## How to See a 2D Array

```
1 2 3
4 5 6      →      grid = [[1,2,3],
7 8 9                    [4,5,6],
                         [7,8,9]]

            row 0 → (0,0) (0,1) (0,2)
            row 1 → (1,0) (1,1) (1,2)
            row 2 → (2,0) (2,1) (2,2)
```

Two facts that matter in every single problem:

```java
grid.length        // number of ROWS (outer array)
grid[0].length     // number of COLUMNS (inner array)
grid[r][c]         // element at row r, column c
```

**Why `grid[0].length` and not `grid[1].length`?** Every row is itself an array; `grid[0]` is the first row, and `.length` on it gives the column count. In a rectangular grid all rows have the same length, so checking row 0 is enough.

---

## The Core Techniques

### 1. Nested traversal: visit every cell once

The single most common operation. An outer loop walks rows, an inner loop walks columns:

```java
for (int r = 0; r < grid.length; r++) {      // rows
    for (int c = 0; c < grid[0].length; c++) {  // columns
        // do something with grid[r][c]
    }
}
```

**Why this works for so many easy problems:** many matrix questions just want you to *look at every cell*. For example, Transpose Matrix (867) is only "read `grid[r][c]`, write it to `result[c][r]`": swapping the roles of row and column. Reshape Matrix (566) is "read the grid in row-major order, write it into a new grid": you map `index -> row = index / cols`, `col = index % cols`.

**Common beginner confusion:** in the inner loop, `grid[0].length` is safe because the outer loop's `r` guarantees at least one row exists. Use `rows` and `cols` variables so you only compute them once.

**Practice:** [1920 Build Array from Permutation](https://leetcode.com/problems/build-array-from-permutation/), [867 Transpose Matrix](https://leetcode.com/problems/transpose-matrix/), [566 Reshape Matrix](https://leetcode.com/problems/reshape-the-matrix/), [1572 Matrix Diagonal Sum](https://leetcode.com/problems/matrix-diagonal-sum/), [2639 Find the Width of Columns of a Grid](https://leetcode.com/problems/find-the-width-of-columns-of-a-grid/)

### 2. Direction arrays: explore up/down/left/right

The single most important matrix technique. Whenever a problem says "each cell has neighbors" (islands, flood fill, word search, rotting oranges, shortest path...), you need to generate the four neighboring coordinates. Instead of writing four blocks of code by hand:

```java
int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}}; // up, down, left, right

for (int[] d : dirs) {
    int nr = r + d[0];   // add the row offset
    int nc = c + d[1];   // add the column offset
    if (nr < 0 || nc < 0 || nr >= rows || nc >= cols) continue; // bounds check
    // work with grid[nr][nc]
}
```

**Why a table and not four `if` statements?** You get to write the neighbor logic once and reuse it. It also extends naturally: for diagonals, use `{{-1,-1},{-1,1},{1,-1},{1,1}}`; for all 8 directions, combine both arrays.

**The bounds check is non-negotiable.** A neighbor at row `-1` or column `cols` simply doesn't exist. Skipping it is what keeps the code from crashing: get comfortable writing it without thinking.

**Practice:** [200 Number of Islands](https://leetcode.com/problems/number-of-islands/), [733 Flood Fill](https://leetcode.com/problems/flood-fill/), [695 Max Area of Island](https://leetcode.com/problems/max-area-of-island/), [79 Word Search](https://leetcode.com/problems/word-search/)

### 3. Visiting cells: don't explore the same cell twice

Most grid searches would loop forever (or redo work) if they revisited cells. Two standard strategies:

```java
boolean[][] visited = new boolean[rows][cols];   // track separately
// ...or mark the grid itself:
grid[r][c] = 0;    // change value so it no longer matches the search condition
```

**When to use which:** a separate `visited` array when the grid's values carry meaning you can't destroy. Modifying the grid in place when it's safe (Flood Fill changes the color anyway; Number of Islands can sink islands to `0`). In-place saves space but mutates input: mention to the interviewer that you did it.

**Where it fits in:** in DFS you mark before recursing; in BFS you mark when you add to the queue (marking on removal is a classic bug that lets duplicates in).

**Practice:** [733 Flood Fill](https://leetcode.com/problems/flood-fill/), [200 Number of Islands](https://leetcode.com/problems/number-of-islands/)

### 4. DFS: explore one branch fully, then backtrack

Depth-first search treats each cell like a graph node connected to its four neighbors. Recursive DFS explores a branch as deep as it can go, then unwinds.

```java
void dfs(int r, int c) {
    if (r < 0 || c < 0 || r >= rows || c >= cols) return;  // bounds
    if (grid[r][c] == 0) return;                            // not part of region
    grid[r][c] = 0;                                        // mark visited
    for (int[] d : dirs) dfs(r + d[0], c + d[1]);          // explore neighbors
}
```

**Why recursion fits grids:** the call stack naturally tracks the path you're on, so you don't manage a stack yourself.

**Use DFS when the question is about *regions or connectivity***: how many islands, the size of the largest island, filling a region with a new color. You're answering "what's connected to this cell?".

**Practice:** [733 Flood Fill](https://leetcode.com/problems/flood-fill/), [200 Number of Islands](https://leetcode.com/problems/number-of-islands/), [695 Max Area of Island](https://leetcode.com/problems/max-area-of-island/), [463 Island Perimeter](https://leetcode.com/problems/island-perimeter/), [130 Surrounded Regions](https://leetcode.com/problems/surrounded-regions/)

### 5. BFS: explore level by level, counting steps

Breadth-first search explores all cells at distance 1, then all at distance 2, etc., using a queue. This level ordering is what makes BFS the tool for **shortest-path / minimum-steps** problems.

```java
Queue<int[]> q = new LinkedList<>();
q.add(new int[]{startR, startC});
visited[startR][startC] = true;
int steps = 0;

while (!q.isEmpty()) {
    int size = q.size();                 // snapshot: one "level"
    for (int i = 0; i < size; i++) {
        int[] cell = q.poll();
        for (int[] d : dirs) {
            int nr = cell[0] + d[0], nc = cell[1] + d[1];
            if (out of bounds || visited || blocked) continue;
            visited[nr][nc] = true;
            q.add(new int[]{nr, nc});
        }
    }
    steps++;
}
```

**The `size` snapshot trick:** processing the queue in batches of `size` lets you count levels: each batch is one step away from the start.

**Multi-source BFS:** instead of one start cell, push *all* sources into the queue at once. In Rotting Oranges (994) you seed the queue with every rotten orange; they all spread at the same rate, so you get the "minutes until all oranges rot" directly. This is a frequent interview trick.

**Quick comparison:** DFS goes deep first, answers connectivity questions. BFS goes wide first, answers distance questions. Same neighborhood concept, different order.

**Practice:** [994 Rotting Oranges](https://leetcode.com/problems/rotting-oranges/), [542 01 Matrix](https://leetcode.com/problems/01-matrix/), [286 Walls and Gates](https://leetcode.com/problems/walls-and-gates/), [1091 Shortest Path in Binary Matrix](https://leetcode.com/problems/shortest-path-in-binary-matrix/)

### Bonus: Backtracking: DFS with undo

Backtracking is DFS plus an undo step. You mark a cell, try a direction, and when it fails you *unmark* and try another:

```java
visited[r][c] = true;
dfs(...);
visited[r][c] = false;   // the undo
```

**Use it when the problem says "find every path" or "does a path exist":** Word Search, Sudoku Solver, N-Queens. The difference from plain DFS is that you're searching for a *specific path* through the grid, so cells must be reusable by other paths.

**Practice:** [79 Word Search](https://leetcode.com/problems/word-search/), [212 Word Search II](https://leetcode.com/problems/word-search-ii/), [37 Sudoku Solver](https://leetcode.com/problems/sudoku-solver/)

### 6. Simulation: follow the rules

**What:** some problems aren't a search at all: they hand you movement or mutation rules and you just execute them.
**Why it feels hard:** there's no single template: you have to *track boundaries or state carefully* as you go.

- Spiral Matrix (54): walk with changing direction, shrinking the borders as you complete each ring.
- Rotate Image (48): do it in layers: transpose then reverse each row, or cycle 4 cells at a time.
- Set Matrix Zeroes (73): mark rows/cols in the first row & column, then fill: avoids extra space.
- Game of Life (289): encode both old and new state in one value so updates don't interfere.

**Practice:** [54 Spiral Matrix](https://leetcode.com/problems/spiral-matrix/), [59 Spiral Matrix II](https://leetcode.com/problems/spiral-matrix-ii/), [48 Rotate Image](https://leetcode.com/problems/rotate-image/), [73 Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes/), [289 Game of Life](https://leetcode.com/problems/game-of-life/)

### 7. Matrix DP: build answers from neighbors

**What:** the answer at `(r,c)` depends on answers at already-computed neighbors: usually **top, left, and diagonal**.

**Why the pattern is consistent:** you only move down and right in these problems, so cells are computed before the ones that depend on them (scan rows top-to-bottom, columns left-to-right).

- Unique Paths (62): `dp[r][c] = dp[r-1][c] + dp[r][c-1]` (ways to arrive = ways from top + ways from left).
- Minimum Path Sum (64): same recurrence, but *take the min* and add the current cost.
- Maximal Square (221): `dp[r][c] = 1 + min(top, left, diagonal)` when the cell is `1`.

**Practice:** [62 Unique Paths](https://leetcode.com/problems/unique-paths/), [64 Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/), [221 Maximal Square](https://leetcode.com/problems/maximal-square/), [329 Longest Increasing Path in a Matrix](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/)

### 8. Prefix sum: instant rectangle sums

**What:** precompute `prefix[r][c]` = sum of the rectangle from `(0,0)` to `(r,c)`. Then any sub-rectangle sum is one formula with inclusion-exclusion:

```java
sum(a,b,c,d) = prefix[c][d]
             - prefix[a-1][d] - prefix[c][b-1]
             + prefix[a-1][b-1];
```

**When to use:** the problem repeatedly asks for the sum (or average) of sub-rectangles. Without the prefix table each query is O(rows*cols); with it, each is O(1).

**Practice:** [304 Range Sum Query 2D](https://leetcode.com/problems/range-sum-query-2d-immutable/), [1314 Matrix Block Sum](https://leetcode.com/problems/matrix-block-sum/)

---

## Pattern Recognition Cheat Sheet

Most matrix problems announce their approach. Ask: what am I doing to the cells?

| If you are... | Use | Example |
|---|---|---|
| visiting every cell once | nested loops | Transpose, Reshape, Diagonal Sum |
| exploring connected regions | DFS | Number of Islands, Flood Fill |
| finding shortest steps | BFS | Rotting Oranges, 01 Matrix |
| following movement rules | simulation | Spiral Matrix, Rotate Image |
| trying every possible path | backtracking | Word Search, N-Queens |
| maximizing/minimizing a quantity | DP | Unique Paths, Maximal Square |
| answering rectangle sums fast | prefix sum matrix | Range Sum Query 2D |
| starting from many sources | multi-source BFS | Rotting Oranges |

**The hardest part is the first question.** Once you know the category, the implementation is mostly mechanical.

---

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
