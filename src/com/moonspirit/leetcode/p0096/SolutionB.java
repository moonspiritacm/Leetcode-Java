package com.moonspirit.leetcode.p0096;

/**
 * 卡塔兰数。O(n) O(1)
 */
class SolutionB {
    public int numTrees(int n) {
        if (n < 0) {
            return 0;
        }

        long dp = 1;
        for (int i = 1; i < n; i++) {
            dp = dp * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) dp;
    }
}
