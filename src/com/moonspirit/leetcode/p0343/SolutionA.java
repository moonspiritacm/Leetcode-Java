package com.moonspirit.leetcode.p0343;

/**
 * 动态规划。O(n^2) O(n)
 */
class SolutionA {
    public int integerBreak(int n) {
        if (n < 2 || n > 58) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], j * (i - j));
                dp[i] = Math.max(dp[i], dp[j] * (i - j));
            }
        }
        return dp[n];
    }
}
