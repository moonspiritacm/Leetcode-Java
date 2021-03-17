package com.moonspirit.leetcode.p0121;

/**
 * 动态规划。O(n) O(n)
 * dp[i]表示截止到第i天能够获得的最大收益：①第i天卖出 ②第i天之前卖出。
 * <p>
 * 执行用时：4 ms, 在所有 Java 提交中击败了 27.53% 的用户
 * 内存消耗：54.2 MB, 在所有 Java 提交中击败了 9.45% 的用户
 */
class Solution1 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int min = prices[0];
        int[] dp = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
        }
        return dp[prices.length - 1];
    }
}
