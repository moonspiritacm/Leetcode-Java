package com.moonspirit.leetcode.p0191;

/**
 * 快速找一。O(logn) O(1)
 */
public class SolutionA {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n &= (n - 1);
            res++;
        }
        return res;
    }
}
