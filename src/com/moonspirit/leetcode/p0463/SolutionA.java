package com.moonspirit.leetcode.p0463;

/**
 * 基本遍历。O(mn) O(1)
 */
class SolutionA {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dict = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res += 4;
                    for (int k = 0; k < 4; k++) {
                        int ii = i + dict[k][0];
                        int jj = j + dict[k][1];
                        if (ii >= 0 && ii < m && jj >= 0 && jj < n && grid[ii][jj] == 1) {
                            res--;
                        }
                    }
                }
            }
        }
        return res;
    }
}
