package com.moonspirit.leetcode.p0136;

/**
 * 位运算。O(n) O(1)
 */
class SolutionA {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        for (int i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }
}
