class Solution {
    static class Cell {
        int row, col;
        boolean canMoveNext;
        long totalCost;

        Cell(int row, int col, boolean canMoveNext, long totalCost) {
            this.row = row;
            this.col = col;
            this.canMoveNext = canMoveNext;
            this.totalCost = totalCost;
        }
    }

    public long minCost(int m, int n, int[][] waitCost) {
        int[][] directions = {{0, 1}, {1, 0}};

        long[][][] costTracker = new long[m][n][2]; 
        boolean[][][] visited = new boolean[m][n][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(costTracker[i][j], Long.MAX_VALUE);
            }
        }

        PriorityQueue<Cell> queue = new PriorityQueue<>(Comparator.comparingLong(c -> c.totalCost));
        costTracker[0][0][1] = 1; 
        queue.offer(new Cell(0, 0, true, 1));

        while (!queue.isEmpty()) {
            Cell current = queue.poll();
            int r = current.row;
            int c = current.col;
            int phase = current.canMoveNext ? 1 : 0;

            if (visited[r][c][phase]) continue;
            visited[r][c][phase] = true;

            if (r == m - 1 && c == n - 1) return current.totalCost;

            if (current.canMoveNext) {
                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr < m && nc < n) {
                        long moveCost = (long) (nr + 1) * (nc + 1);
                        long nextCost = current.totalCost + moveCost;
                        if (nextCost < costTracker[nr][nc][0]) {
                            costTracker[nr][nc][0] = nextCost;
                            queue.offer(new Cell(nr, nc, false, nextCost));
                        }
                    }
                }
            } else {
                long wait = waitCost[r][c];
                long nextCost = current.totalCost + wait;
                if (nextCost < costTracker[r][c][1]) {
                    costTracker[r][c][1] = nextCost;
                    queue.offer(new Cell(r, c, true, nextCost));
                }
            }
        }

        return -1;
    }
}
