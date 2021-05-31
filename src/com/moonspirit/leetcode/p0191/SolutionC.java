package com.moonspirit.leetcode.p0191;

/**
 * 位运算。O(n) O(1)
 */
public class SolutionC {
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                res++;
            }
            //res += n >> i & 1;
        }
        return res;
    }
}
