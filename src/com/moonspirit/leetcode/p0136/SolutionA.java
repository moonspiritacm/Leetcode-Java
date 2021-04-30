package com.moonspirit.leetcode.p0136;

/**
 * 异或运算。O(n) O(1)
 * 全部元素的异或运算结果即为数组中只出现一次的数字。
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
