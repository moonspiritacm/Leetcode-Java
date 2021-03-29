package com.moonspirit.leetcode.p0198;

/**
 * 动态规划。O(n) O(n)
 * dp[i]表示打劫前i户获得的最大金额：①不打劫第i户dp[i-1] ②打劫第i户dp[i-2]+nums[i-1]，取较大者。
 */
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }
}
