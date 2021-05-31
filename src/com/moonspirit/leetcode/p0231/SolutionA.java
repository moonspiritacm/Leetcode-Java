package com.moonspirit.leetcode.p0231;

/**
 * 最低位1。O(1) O(1)
 */
class SolutionA {
    public boolean isPowerOfTwo(int n) {
        //return n > 0 && (n & (n - 1)) == 0;
        return n > 0 && (n & (-n)) == n;
    }
}
