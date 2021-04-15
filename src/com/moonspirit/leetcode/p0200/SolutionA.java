package com.moonspirit.leetcode.p0200;

/**
 * 深度优先搜索。O(mn) O(mn)
 */
class SolutionA {
    private void dfs(char[][] grid, int[][] dict, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '2';
        for (int k = 0; k < 4; k++) {
            dfs(grid, dict, i + dict[k][0], j + dict[k][1]);
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int num = 0;
        int[][] dict = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, dict, i, j);
                    num++;
                }
            }
        }
        return num;
    }
}
