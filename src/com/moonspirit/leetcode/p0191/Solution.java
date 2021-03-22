package com.moonspirit.leetcode.p0191;

/**
 * 位运算。O(n) O(1)
 * 注意，>>>无符号右移，高位补0。
 */
public class Solution {
    public int hammingWeight(int n) {
        int num = 0;
        while (n != 0) {
            num += n & 1;
            n = n >>> 1;
        }
        return num;
    }
}
