package com.moonspirit.leetcode.p0461;

/**
 * Brian Kernighan。O(logC) O(1)
 */
class SolutionA {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int res = 0;
        while (z != 0) {
            z &= z - 1;
            res++;
        }
        return res;
    }
}
