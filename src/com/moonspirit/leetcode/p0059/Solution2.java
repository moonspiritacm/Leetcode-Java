package com.moonspirit.leetcode.p0059;

/**
 * 维护访问状态。O(n^2) O(1)
 * 超出界限或者遇到已访问元素时，顺时针旋转，直到每个位置都填充满（路径长度等于元素个数）。
 * <p>
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：36.2 MB, 在所有 Java 提交中击败了 98.64% 的用户
 */
class Solution2 {
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[][]{{}};
        }
        if (n == 1) {
            return new int[][]{{1}};
        }

        int num = 1;
        int i = 0;
        int j = 0;
        int r = 0;
        int[][] res = new int[n][n];
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (num <= n * n) {
            res[i][j] = num++;
            int ii = i + dir[r][0];
            int jj = j + dir[r][1];
            if (ii < 0 || ii >= n || jj < 0 || jj >= n || res[ii][jj] != 0) {
                r = (r + 1) % 4;
            }
            i += dir[r][0];
            j += dir[r][1];
        }
        return res;
    }
}
