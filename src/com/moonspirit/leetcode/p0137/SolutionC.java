package com.moonspirit.leetcode.p0137;

/**
 * 逻辑电路（先b再a）。O(n) O(1)
 */
class SolutionC {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int a = 0;
        int b = 0;
        for (int num : nums) {
            b = (~a) & (b ^ num);
            a = (~b) & (a ^ num);
        }
        return b;
    }
}
