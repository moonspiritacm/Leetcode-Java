package com.moonspirit.leetcode.p0303;

/**
 * 数组前缀和。O(n)+O(1) O(n)
 * sums[i]为[0, i]前缀和：
 * 对于 i=0，sums[0] = nums[0]，sums(0, j) = sums[j];
 * 对于 i>0，sums[i] = sums[i-1] + nums[i]，sums(i, j) = sums[j] - sums[i-1]。
 * 执行用时：10 ms, 在所有 Java 提交中击败了 77.14% 的用户
 * 内存消耗：41.1 MB, 在所有 Java 提交中击败了 92.32% 的用户
 */
class NumArray {
    int[] sums;

    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return sums[j];
        } else {
            return sums[j] - sums[i - 1];
        }
    }
}
