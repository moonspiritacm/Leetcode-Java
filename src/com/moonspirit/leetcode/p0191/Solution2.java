package com.moonspirit.leetcode.p0191;

/**
 * 位运算。O(n) O(1)
 */
public class Solution2 {
    public int hammingWeight(int n) {
        int num = 0;
        for (int i = 0; i < 32; i++) {
            num += (n >> i) & 1;
        }
        return num;
    }
}
