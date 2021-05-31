package com.moonspirit.leetcode.p0461;

/**
 * 移位计数。O(k) O(1)
 */
class SolutionB {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int res = 0;
        while (z != 0) {
            res += z & 1;
            z >>>= 1;
        }
        return res;
    }
}
