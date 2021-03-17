package com.moonspirit.leetcode.p0053;

/**
 * 动态规划。O(n) O(n)
 * dp[i]表示以nums[i]结尾的连续子数组的最大和：①在dp[i-1]的基础上增加nums[i] ②以nums[i]开头的新连续子数组。
 * <p>
 * 执行用时：1 ms, 在所有 Java 提交中击败了 94.84% 的用户
 * 内存消耗：38.5 MB, 在所有 Java 提交中击败了 30.81% 的用户
 */
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
