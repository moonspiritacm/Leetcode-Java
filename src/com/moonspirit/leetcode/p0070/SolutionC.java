package com.moonspirit.leetcode.p0070;

/**
 * 记忆化递归。O(n) O(n)
 */
class SolutionC {
    private int[] dp;

    private int helper(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = helper(n - 1) + helper(n - 2);
        return dp[n];
    }

    public int climbStairs(int n) {
        if (n < 0) {
            return 0;
        }

        dp = new int[n + 1];
        return helper(n);
    }
}
