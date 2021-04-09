package com.moonspirit.leetcode.p0154;

/**
 * 暴力搜索。O(n) O(1)
 */
class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[0]) {
                return nums[i];
            }
        }
        return nums[0];
    }
}
