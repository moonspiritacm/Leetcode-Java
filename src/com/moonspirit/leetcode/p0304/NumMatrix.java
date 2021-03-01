package com.moonspirit.leetcode.p0304;

/**
 * 矩阵前缀和，边界情况无须特殊处理。O(mn)+O(1) O(mn)
 * sums[i,j]为[(0,0), (i,j))前缀和：sums[i+1][j+1] = sums[i][j+1] + nums[i+1][j] - nums[i][j]。
 * 执行用时：14 ms, 在所有 Java 提交中击败了 98.81% 的用户
 * 内存消耗：44.3 MB, 在所有 Java 提交中击败了 14.34% 的用户
 */
class NumMatrix {
    int[][] sums;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        sums = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sums[i + 1][j + 1] = sums[i + 1][j] + sums[i][j + 1] - sums[i][j] + matrix[i][j];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
    }
}
