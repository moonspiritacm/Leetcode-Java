package com.moonspirit.leetcode.p0342;

/**
 * 掩码。O(1) O(1)
 */
class SolutionA {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xAAAAAAAA) == 0;
    }
}
