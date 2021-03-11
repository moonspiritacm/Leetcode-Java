package com.moonspirit.leetcode.p0026;

/**
 * 快慢指针。O(n) O(1)
 * <p>
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：40.6 MB, 在所有 Java 提交中击败了 5.21% 的用户
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int pos = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[pos]) {
                pos++;
                nums[pos] = nums[i];
            }
        }
        return pos + 1;
    }
}
