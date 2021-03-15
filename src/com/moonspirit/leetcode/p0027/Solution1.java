package com.moonspirit.leetcode.p0027;

/**
 * 双指针——前移。O(n) O(1)
 * <p>
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：37.1 MB, 在所有 Java 提交中击败了 36.00% 的用户
 */
class Solution1 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[n++] = nums[i];
            }
        }
        return n;
    }
}
