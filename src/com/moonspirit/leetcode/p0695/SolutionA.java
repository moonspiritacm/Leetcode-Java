package com.moonspirit.leetcode.p0695;

/**
 * 深度优先搜索。O(mn) O(mn)
 */
class SolutionA {
    private int dfs(int[][] grid, int[][] dict, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = 2;
        int ans = 1;
        for (int k = 0; k < 4; k++) {
            ans += dfs(grid, dict, i + dict[k][0], j + dict[k][1]);
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
                    int ans = dfs(grid, dict, i, j);
                    res = Math.max(res, ans);
                }
            }
        }
        return res;
    }
}
