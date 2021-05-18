package com.moonspirit.leetcode.p0137;

/**
 * 逐位计算。O(32n) O(1)
 */
class SolutionA {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < 32; i++) {
            int tmp = 0;
            for (int num : nums) {
                tmp += (num >> i) & 1;
            }
            res |= (tmp % 3) << i;
        }
        return res;
    }
}
