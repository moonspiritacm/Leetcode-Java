package com.moonspirit.leetcode.p0303;

/**
 * 逻辑优化，边界情况无须特殊处理。O(n)+O(1) O(n)
 * sums[i]为[0, i)前缀和：sums[i+1] = sums[i] + nums[i]，sums(i, j) = sums[j+1] - sums[i]。
 * 执行用时：10 ms, 在所有 Java 提交中击败了 77.14% 的用户
 * 内存消耗：41.4 MB, 在所有 Java 提交中击败了 48.37% 的用户
 */
class NumArray1 {
    int[] sums;

    public NumArray1(int[] nums) {
        sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}
