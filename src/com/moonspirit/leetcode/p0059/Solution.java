package com.moonspirit.leetcode.p0059;

/**
 * 逐圈扫描。O(n^2) O(1)
 * 从左到右遍历上侧元素，以此由(cnt, cnt)到(cnt, n-1-cnt)
 * 从上到下遍历右侧元素，以此由(cnt+1, n-1-cnt)到(n-1-cnt, n-1-cnt)
 * 从右到左遍历下侧元素，以此由(n-1-cnt, n-2-cnt)到(n-1-cnt, cnt)
 * 从下到上遍历左侧元素，以此由(n-2-cnt, cnt)到(cnt+1, cnt)
 * 遍历下侧和左侧元素是非必须的，取决于行列的奇偶性，避免重复添加。
 * <p>
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：36.6 MB, 在所有 Java 提交中击败了 54.83% 的用户
 */
class Solution {
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[][]{{}};
        }
        if (n == 1) {
            return new int[][]{{1}};
        }

        int num = 1;
        int cnt = 0;
        int[][] res = new int[n][n];
        while (cnt < n / 2) {
            for (int i = cnt; i <= n - 1 - cnt; i++) {
                res[cnt][i] = num++;
            }
            for (int i = cnt + 1; i <= n - 1 - cnt; i++) {
                res[i][n - 1 - cnt] = num++;
            }
            for (int i = n - 2 - cnt; i >= cnt; i--) {
                res[n - 1 - cnt][i] = num++;
            }
            for (int i = n - 2 - cnt; i >= cnt + 1; i--) {
                res[i][cnt] = num++;
            }
            cnt++;
        }
        if (n % 2 == 1) {
            res[n / 2][n / 2] = num;
        }
        return res;
    }
}
