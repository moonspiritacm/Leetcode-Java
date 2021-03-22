package com.moonspirit.leetcode.p0073;

/**
 * 位运算空间压缩。
 * 对于32位整型，能够记录的状态最多32个，不适用于本题。
 */
class Solution3 {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row |= 1 << i;
                    col |= 1 << j;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if ((row & (1 << i)) != 0) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            if ((col & (1 << j)) != 0) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
