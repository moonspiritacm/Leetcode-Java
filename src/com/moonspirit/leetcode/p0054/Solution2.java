package com.moonspirit.leetcode.p0054;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用辅助数组记录访问状态。O(mn) O(mn)
 * 当路径超出界限或者遇见已访问元素时，顺时针旋转，直到矩阵中的每个元素都被访问一次（路径长度等于元素个数）。
 * <p>
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：36.4 MB, 在所有 Java 提交中击败了 86.44% 的用户
 */
class Solution2 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] flag = new boolean[m][n];
        List<Integer> res = new ArrayList<>();
        int row = 0;
        int col = 0;
        int cnt = 0;
        int direct = 0;
        int[][] next = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (cnt++ < m * n) {
            res.add(matrix[row][col]);
            flag[row][col] = true;
            int r = row + next[direct][0];
            int c = col + next[direct][1];
            if (r < 0 || r > m - 1 || c < 0 || c > n - 1 || flag[r][c]) {
                direct++;
                direct %= 4;
            }
            row += next[direct][0];
            col += next[direct][1];
        }
        return res;
    }
}
