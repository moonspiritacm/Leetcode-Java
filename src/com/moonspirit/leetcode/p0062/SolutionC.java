package com.moonspirit.leetcode.p0062;

/**
 * 记忆化递归。O(n^2) O(n^2)
 */
class SolutionC {
    private int[][] dp;

    private int helper(int m, int n) {
        if (m == 0 || n == 0) {
            return 1;
        }
        if (dp[m][n] != 0) {
            return dp[m][n];
        }

        dp[m][n] = helper(m - 1, n) + helper(m, n - 1);
        return dp[m][n];
    }

    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }

        dp = new int[m][n];
        return helper(m - 1, n - 1);
    }
}
