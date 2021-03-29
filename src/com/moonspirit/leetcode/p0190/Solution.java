package com.moonspirit.leetcode.p0190;

/**
 * 逐位颠倒。O(1) O(1)
 */
public class Solution {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n >> i & 1) != 0) {
                res += 1 << (31 - i);
            }
        }
        return res;
    }
}
