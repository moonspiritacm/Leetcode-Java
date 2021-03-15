package com.moonspirit.leetcode.p0054;

import java.util.ArrayList;
import java.util.List;

/**
 * 逐圈扫描。O(mn) O(1)
 * 从左到右遍历上侧元素，以此由(cnt, cnt)到(cnt, n-1-cnt)
 * 从上到下遍历右侧元素，以此由(cnt+1, n-1-cnt)到(m-1-cnt, n-1-cnt)
 * 从右到左遍历下侧元素，以此由(m-1-cnt, n-2-cnt)到(m-1-cnt, cnt)
 * 从下到上遍历左侧元素，以此由(m-2-cnt, cnt)到(cnt+1, cnt)
 * 遍历下侧和左侧元素是非必须的，取决于行列的奇偶性，避免重复添加。
 * <p>
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：36.7 MB, 在所有 Java 提交中击败了 29.63% 的用户
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int top = (Math.min(m, n) + 1) / 2;
        int cnt = 0;
        List<Integer> res = new ArrayList<>();
        while (cnt < top) {
            for (int i = cnt; i <= n - 1 - cnt; i++) {
                res.add(matrix[cnt][i]);
            }
            for (int i = cnt + 1; i <= m - 1 - cnt; i++) {
                res.add(matrix[i][n - 1 - cnt]);
            }
            if (m - 1 - cnt > cnt) {
                for (int i = n - 2 - cnt; i >= cnt; i--) {
                    res.add(matrix[m - 1 - cnt][i]);
                }
            }
            if (n - 1 - cnt > cnt) {
                for (int i = m - 2 - cnt; i >= cnt + 1; i--) {
                    res.add(matrix[i][cnt]);
                }
            }
            cnt++;
        }
        return res;
    }
}
