package com.moonspirit.leetcode.p0027;

/**
 * 双指针——交换。O(n) O(1)
 * 如果要移除的元素很少，效率会更高。
 * <p>
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：37.1 MB, 在所有 Java 提交中击败了 36.00% 的用户
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[l] == val) {
                nums[l] = nums[r];
                r--;
            } else {
                l++;
            }
        }
        return r + 1;
    }
}
