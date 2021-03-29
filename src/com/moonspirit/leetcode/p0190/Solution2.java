package com.moonspirit.leetcode.p0190;

/**
 * 逐位颠倒。O(1) O(1)
 */
public class Solution2 {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            res |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return res;
    }
}
