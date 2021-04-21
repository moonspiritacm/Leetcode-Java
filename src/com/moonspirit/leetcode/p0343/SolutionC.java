package com.moonspirit.leetcode.p0343;

/**
 * 记忆化递归。O(n^2) O(n)
 */
class SolutionC {
    private int[] dp;

    private int helper(int n) {
        if (n < 2) {
            return n;
        }
        if (dp[n] != 0) {
            return dp[n];
        }

        for (int i = 1; i < n; i++) {
            dp[n] = Math.max(dp[n], i * (n - i));
            dp[n] = Math.max(dp[n], helper(i) * (n - i));
        }
        return dp[n];
    }

    public int integerBreak(int n) {
        if (n < 2 || n > 58) {
            return 0;
        }

        dp = new int[n + 1];
        return helper(n);
    }
}
