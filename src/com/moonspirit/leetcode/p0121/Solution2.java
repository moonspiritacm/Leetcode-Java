package com.moonspirit.leetcode.p0121;

/**
 * 存储优化。O(n) O(1)
 * <p>
 * 执行用时：3 ms, 在所有 Java 提交中击败了 48.48% 的用户
 * 内存消耗：51.4 MB, 在所有 Java 提交中击败了 38.83% 的用户
 */
class Solution2 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int min = prices[0];
        int pre = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            pre = Math.max(pre, prices[i] - min);
        }
        return pre;
    }
}
