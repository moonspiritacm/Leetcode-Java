package com.moonspirit.leetcode.p0695;

class Solution {
    int res;
    int[] ix = {-1, 0, 1, 0};
    int[] iy = {0, -1, 0, 1};
    boolean[][] isVisited;

    private int dfs(int[][] grid, int x, int y) {
        int num = 0;
        for (int i = 0; i < 4; i++) {
            int a = x + ix[i];
            int b = y + iy[i];
            if (a >= 0 && b >= 0 && a < grid.length && b < grid[0].length && grid[a][b] == 1 && !isVisited[a][b]) {
                isVisited[a][b] = true;
                num += dfs(grid, a, b);
            }
        }
        return num;
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        isVisited = new boolean[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !isVisited[i][j]) {
                    isVisited[i][j] = true;
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max;
    }
}
