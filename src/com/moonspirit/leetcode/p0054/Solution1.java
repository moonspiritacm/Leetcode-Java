package com.moonspirit.leetcode.p0054;

import java.util.ArrayList;
import java.util.List;

/**
 * 逐圈扫描。O(mn) O(1)
 * 从左到右遍历上侧元素，以此由(top, left)到(top, right)
 * 从上到下遍历右侧元素，以此由(top+1, right)到(bottom, right)
 * 从右到左遍历下侧元素，以此由(bottom, right-1)到(bottom, left)
 * 从下到上遍历左侧元素，以此由(bottom-1, left)到(top+1, left)
 * 遍历下侧和左侧元素是非必须的，取决于行列的奇偶性，避免重复添加（left==right && top==bottom）。
 * <p>
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：36.6 MB, 在所有 Java 提交中击败了 65.77% 的用户
 */
class Solution1 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int top = 0;
        int right = n - 1;
        int bottom = m - 1;
        int cnt = 0;
        List<Integer> res = new ArrayList<>();
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            if (top < bottom) {
                for (int i = right - 1; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
            }
            if (left < right) {
                for (int i = bottom - 1; i >= top + 1; i--) {
                    res.add(matrix[i][left]);
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
