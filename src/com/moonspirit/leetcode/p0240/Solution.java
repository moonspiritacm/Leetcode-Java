package com.moonspirit.leetcode.p0240;

/**
 * 缩减空间。O(m+n) O(1)
 * 从右上角开始遍历：
 * 如果目标值大于当前元素，目标值只可能出现在下方，行数加一；
 * 如果目标值小于当前元素，目标值只可能出现在左侧，列数减一。
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
