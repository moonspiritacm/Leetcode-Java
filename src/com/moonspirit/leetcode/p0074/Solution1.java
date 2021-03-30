package com.moonspirit.leetcode.p0074;

/**
 * 一轮二分查找。O(logmn) O(1)
 * 将二维数据降维到一维数组，再进行二分查找。
 */
class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m * n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (matrix[mid / n][mid % n] > target) {
                r = mid - 1;
            } else if (matrix[mid / n][mid % n] < target) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
