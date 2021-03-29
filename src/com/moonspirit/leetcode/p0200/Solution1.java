package com.moonspirit.leetcode.p0200;

/**
 * 深度优先搜索。O(mn) O(mn)
 */
class Solution1 {
    private int[][] dirt = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '2';
        for (int k = 0; k < 4; k++) {
            dfs(grid, i + dirt[k][0], j + dirt[k][1]);
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }
}
