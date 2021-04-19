package com.moonspirit.leetcode.p0070;

/**
 * 存储优化。O(n) O(1)
 */
class SolutionB {
    public int climbStairs(int n) {
        if (n < 0) {
            return 0;
        }

        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i % 2] = dp[(i - 1) % 2] + dp[(i - 2) % 2];
        }
        return dp[n % 2];
    }
}
