package com.moonspirit.leetcode.p0343;

/**
 * 降维动态规划。O(n) O(n)
 */
class SolutionB {
    public int integerBreak(int n) {
        if (n < 2 || n > 58) {
            return 0;
        }
        if (n < 4) {
            return n - 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i], 2 * (i - 2));
            dp[i] = Math.max(dp[i], 2 * dp[i - 2]);
            dp[i] = Math.max(dp[i], 3 * (i - 3));
            dp[i] = Math.max(dp[i], 3 * dp[i - 3]);
        }
        return dp[n];
    }
}
