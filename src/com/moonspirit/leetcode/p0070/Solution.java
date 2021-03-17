package com.moonspirit.leetcode.p0070;

/**
 * 动态规划。O(n) O(n)
 * dp[i]表示爬到第i级台阶的方案数：①从dp[i-1]跨一步 ②从dp[i-2]跨两步。
 * <p>
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：35.1 MB, 在所有 Java 提交中击败了 70.75% 的用户
 */
class Solution {
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
