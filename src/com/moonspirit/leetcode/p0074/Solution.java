package com.moonspirit.leetcode.p0074;

/**
 * 两轮二分查找。O(logm+logn) O(1)
 * 行尾数组的二分查找，找到目标值所在行；
 * 行内数组的二分查找，找到目标值待插入位置。
 * 注意，目标值所在行可能越上界，即目标值比任何元素都大。
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (matrix[mid][n - 1] > target) {
                r = mid - 1;
            } else if (matrix[mid][n - 1] < target) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        if (l >= m) {
            return false;
        }
        int row = l;
        l = 0;
        r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (matrix[row][mid] > target) {
                r = mid - 1;
            } else if (matrix[row][mid] < target) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
