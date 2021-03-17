package com.moonspirit.leetcode.p0070;

/**
 * 存储优化。O(n) O(1)
 * <p>
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：35.1 MB, 在所有 Java 提交中击败了 70.75% 的用户
 */
class Solution1 {
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }

        int[] dp = new int[2];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i % 2] = dp[(i - 1) % 2] + dp[(i - 2) % 2];
        }
        return dp[n % 2];
    }
}
