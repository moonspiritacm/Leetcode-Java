package com.moonspirit.leetcode.p0198;

/**
 * 存储优化。O(n) O(1)
 * dp[i]仅与dp[i-1]、dp[i-2]有关，使用规模为2的滚动数组。
 */
class Solution1 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i % 2] = Math.max(dp[(i - 1) % 2], dp[(i - 2) % 2] + nums[i - 1]);
        }
        return dp[nums.length % 2];
    }
}
