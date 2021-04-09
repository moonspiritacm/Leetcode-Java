package com.moonspirit.leetcode.p0154;

/**
 * 二分查找。O(logn) O(1)
 */
class Solution1 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else if (nums[m] < nums[r]) {
                r = m;
            } else {
                r = r - 1;
            }
        }
        return nums[l];
    }
}
