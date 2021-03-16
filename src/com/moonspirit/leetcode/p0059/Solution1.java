package com.moonspirit.leetcode.p0059;

/**
 * 逐圈扫描。O(n^2) O(1)
 * 从左到右遍历上侧元素，以此由(top, left)到(top, right)
 * 从上到下遍历右侧元素，以此由(top+1, right)到(bottom, right)
 * 从右到左遍历下侧元素，以此由(bottom, right-1)到(bottom, left)
 * 从下到上遍历左侧元素，以此由(bottom-1, left)到(top+1, left)
 * 遍历下侧和左侧元素是非必须的，取决于行列的奇偶性，避免重复添加（left==right && top==bottom）。
 * <p>
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：36.8 MB, 在所有 Java 提交中击败了 5.46% 的用户
 */
class Solution1 {
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[][]{{}};
        }
        if (n == 1) {
            return new int[][]{{1}};
        }

        int num = 1;
        int left = 0;
        int top = 0;
        int right = n - 1;
        int bottom = n - 1;
        int[][] res = new int[n][n];
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                res[top][i] = num++;
            }
            for (int i = top + 1; i <= bottom; i++) {
                res[i][right] = num++;
            }
            if (top < bottom) {
                for (int i = right - 1; i >= left; i--) {
                    res[bottom][i] = num++;
                }
            }
            if (left < right) {
                for (int i = bottom - 1; i >= top + 1; i--) {
                    res[i][left] = num++;
                }
            }
            left++;
            top++;
            right--;
            bottom--;
        }
        return res;
    }
}
