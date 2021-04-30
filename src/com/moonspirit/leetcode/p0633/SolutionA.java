package com.moonspirit.leetcode.p0633;

/**
 * 开方运算。O(n^0.5) O(1)
 */
class SolutionA {
    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }

        for (long a = 0; a * a <= c; a++) {
            long b = (long) Math.sqrt(c - a * a);
            if (b * b == c - a * a) {
                return true;
            }
        }
        return false;
    }
}
