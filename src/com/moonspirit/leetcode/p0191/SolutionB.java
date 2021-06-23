package com.moonspirit.leetcode.p0191;

/**
 * 无符号右移。O(k) O(1)
 */
public class SolutionB {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }
}
