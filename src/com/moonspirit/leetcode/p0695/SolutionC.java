package com.moonspirit.leetcode.p0695;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先搜索。O(mn) O(min(m,n))
 */
class SolutionC {
    private int bfs(int[][] grid, int[][] dict, int i, int j) {
        int ans = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i * grid[0].length + j);
        while (!queue.isEmpty()) {
            ans++;
            int pos = queue.poll();
            for (int k = 0; k < 4; k++) {
                int ii = pos / grid[0].length + dict[k][0];
                int jj = pos % grid[0].length + dict[k][1];
                if (ii >= 0 && ii < grid.length && jj >= 0 && jj < grid[0].length && grid[ii][jj] == 1) {
                    grid[ii][jj] = 2;
                    queue.offer(ii * grid[0].length + jj);
                }
            }
        }
        return ans;
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int res = 0;
        int[][] dict = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 2;
                    int ans = bfs(grid, dict, i, j);
                    res = Math.max(res, ans);
                }
            }
        }
        return res;
    }
}
