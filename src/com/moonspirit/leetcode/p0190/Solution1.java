package com.moonspirit.leetcode.p0190;

/**
 * 逐位颠倒。O(1) O(1)
 */
public class Solution1 {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                res += 1 << (31 - i);
            }
        }
        return res;
    }
}
