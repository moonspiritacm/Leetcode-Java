package com.moonspirit.leetcode.p0053;

/**
 * 存储优化。O(n) O(1)
 * <p>
 * 执行用时：1 ms, 在所有 Java 提交中击败了 94.84% 的用户
 * 内存消耗：38.5 MB, 在所有 Java 提交中击败了 24.55% 的用户
 */
class Solution1 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int pre = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(max, pre);
        }
        return max;
    }
}
