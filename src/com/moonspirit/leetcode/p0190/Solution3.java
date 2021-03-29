package com.moonspirit.leetcode.p0190;

/**
 * 分治。
 * 按奇偶位，自低向下分步颠倒，需要颠倒5次（1、2、4、8、16）：
 * (n&M1)<<1 取奇数位的1，左移一位，移至偶数位；
 * (n>>>1)&M1 右移一位，移至奇数位，再取偶数位的1。
 */
public class Solution3 {
    private static final int M1 = 0x55555555; // 01010101010101010101010101010101
    private static final int M2 = 0x33333333; // 00110011001100110011001100110011
    private static final int M4 = 0x0f0f0f0f; // 00001111000011110000111100001111
    private static final int M8 = 0x00ff00ff; // 00000000111111110000000011111111

    public int reverseBits(int n) {
        n = n >>> 1 & M1 | (n & M1) << 1;
        n = n >>> 2 & M2 | (n & M2) << 2;
        n = n >>> 4 & M4 | (n & M4) << 4;
        n = n >>> 8 & M8 | (n & M8) << 8;
        return n >>> 16 | n << 16;
    }
}
