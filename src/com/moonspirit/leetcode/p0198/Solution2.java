package com.moonspirit.leetcode.p0198;

import java.util.Arrays;

/**
 * 记忆化递归。O(n) O(n)
 */
class Solution2 {
    private int[] dp;

    private int helper(int[] nums, int i) {
        if (i <= 1) {
            return dp[i];
        }
        if (dp[i] != -1) {
            return dp[i];
        }

        dp[i - 1] = helper(nums, i - 1);
        dp[i - 2] = helper(nums, i - 2);
        dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        return dp[i];
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = nums[0];
        return helper(nums, nums.length);
    }
}
