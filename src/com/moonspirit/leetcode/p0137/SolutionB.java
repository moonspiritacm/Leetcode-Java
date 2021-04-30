package com.moonspirit.leetcode.p0137;

/**
 * 逻辑电路（a、b同时计算）。O(n) O(1)
 * a = (~a)&b&x | a&(~b)&(~c)
 * b = (~a)&(b^x)
 */
class SolutionB {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int a = 0;
        int b = 0;
        for (int num : nums) {
            int ta = (~a) & b & num | a & (~b) & (~num);
            int tb = (~a) & (b ^ num);
            a = ta;
            b = tb;
        }
        return b;
    }
}
