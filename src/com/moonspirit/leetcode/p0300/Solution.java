package com.moonspirit.leetcode.p0300;

/**
 * 动态规划。O(n^2) O(n)
 * dp[i]为考虑前i个元素，以第i个数字结尾的最长递增子序列的长度：dp[i]=max(dp[j])+1，其中0≤j<i且num[j]<num[i]
 * <p>
 * 执行用时：73 ms, 在所有 Java 提交中击败了 59.79% 的用户
 * 内存消耗：38.4 MB, 在所有 Java 提交中击败了 8.85% 的用户
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
