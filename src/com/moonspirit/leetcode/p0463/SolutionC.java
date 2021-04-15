package com.moonspirit.leetcode.p0463;

/**
 * 深度优先搜索。O(mn) O(mn)
 */
class SolutionC {
    private int dfs(int[][] grid, int[][] dict, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 1;
        }
        if (grid[i][j] == 2) {
            return 0;
        }

        int ans = 0;
        grid[i][j] = 2;
        for (int k = 0; k < 4; k++) {
            ans += dfs(grid, dict, i + dict[k][0], j + dict[k][1]);
        }
        return ans;
    }

    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int res = 0;
        int[][] dict = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res += dfs(grid, dict, i, j);
                }
            }
        }
        return res;
    }
}
