package com.moonspirit.leetcode.p0198;

/**
 * 空间优化。O(n) O(1)
 * dp[i]仅与dp[i-1]、dp[i-2]有关，使用规模为3的滚动数组。
 */
class Solution1 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[3];
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i % 3] = Math.max(dp[(i - 1) % 3], dp[(i - 2) % 3] + nums[i - 1]);
        }
        return dp[nums.length % 3];
    }
}
