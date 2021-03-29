package com.moonspirit.leetcode.p0200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先搜索。O(mn) O(min(m,n))
 */
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirt = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    res++;
                    while (!queue.isEmpty()) {
                        int[] pos = queue.poll();
                        grid[pos[0]][pos[1]] = '2';
                        for (int k = 0; k < 4; k++) {
                            int ix = pos[0] + dirt[k][0];
                            int jx = pos[1] + dirt[k][1];
                            if (ix >= 0 && ix < m && jx >= 0 && jx < n && grid[ix][jx] == '1') {
                                queue.offer(new int[]{ix, jx});
                                grid[ix][jx] = '2';
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
