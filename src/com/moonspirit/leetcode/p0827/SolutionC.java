package com.moonspirit.leetcode.p0827;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 广度优先搜索。O(mn) O(min(m,n))
 */
class SolutionC {
    private int bfs(int[][] grid, int[][] dict, int i, int j, int id) {
        int ans = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i * grid[0].length + j);
        grid[i][j] = id;
        while (!queue.isEmpty()) {
            int pos = queue.poll();
            for (int k = 0; k < 4; k++) {
                int ii = pos / grid[0].length + dict[k][0];
                int jj = pos % grid[0].length + dict[k][1];
                if (ii >= 0 && ii < grid.length && jj >= 0 && jj < grid[0].length && grid[ii][jj] == 1) {
                    queue.offer(ii * grid[0].length + jj);
                    grid[ii][jj] = id;
                    ans++;
                }
            }
        }
        return ans;
    }

    public int largestIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int res = 0;
        int id = 2;
        int m = grid.length;
        int n = grid[0].length;
        int[] area = new int[m * n + 2];
        int[][] dict = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    area[id] = bfs(grid, dict, i, j, id);
                    res = Math.max(res, area[id++]);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int sum = 1;
                    Set<Integer> board = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int ii = i + dict[k][0];
                        int jj = j + dict[k][1];
                        if (ii >= 0 && ii < grid.length && jj >= 0 && jj < grid[0].length && grid[ii][jj] > 1) {
                            board.add(grid[ii][jj]);
                        }
                    }
                    for (int pos : board) {
                        sum += area[pos];
                    }
                    res = Math.max(res, sum);
                }
            }
        }
        return res;
    }
}
