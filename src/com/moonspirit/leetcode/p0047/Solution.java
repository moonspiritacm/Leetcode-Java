package com.moonspirit.leetcode.p0047;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 排列去重。O(n*n!) O(n)
 * 只需保证，保证在填第i个元素的时候，重复数字只填入一次。
 * 首先对原数组排序，保证相同数字相邻，然后每次填入的数一定是作为第i个元素首次出现。
 * <p>
 * 执行用时：3 ms, 在所有 Java 提交中击败了 34.02% 的用户
 * 内存消耗：39.1 MB, 在所有 Java 提交中击败了 75.79% 的用户
 */
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> ans = new ArrayList<>();
    private boolean[] flag;

    private void helper(int[] nums, int n) {
        if (n == nums.length) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!flag[i] && (i == 0 || !flag[i - 1] || nums[i - 1] != nums[i])) {
                flag[i] = true;
                ans.add(nums[i]);
                helper(nums, n + 1);
                ans.remove(ans.size() - 1);
                flag[i] = false;
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }

        flag = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, 0);
        return res;
    }
}
