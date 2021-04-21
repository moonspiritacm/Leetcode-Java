package com.moonspirit.leetcode.p0343;

/**
 * 数学。O(1) O(1)
 */
public class SolutionD {
    public int integerBreak(int n) {
        if (n < 2 || n > 58) {
            return 0;
        }
        if (n < 4) {
            return n - 1;
        }

        if (n % 3 == 0) {
            return (int) Math.pow(3, n / 3);
        } else if (n % 3 == 2) {
            return (int) Math.pow(3, n / 3) * 2;
        } else {
            return (int) Math.pow(3, (n - 4) / 3) * 4;
        }
    }
}
