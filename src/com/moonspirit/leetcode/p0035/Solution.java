package com.moonspirit.leetcode.p0035;

/**
 * 基础二分查找。O(logn) O(1)
 * 如果没有找到目标元素，l停在恰好比目标大的位置（插入位置）上，r停在恰好比目标小的位置上。
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            // int m = l + (r - l) / 2;
            // int m = (l + r) / 2;
            // int m = (l + r) >> 1;
            if (target < nums[m]) {
                r = m - 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return l;
    }
}
