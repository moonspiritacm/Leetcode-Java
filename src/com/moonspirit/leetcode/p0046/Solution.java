package com.moonspirit.leetcode.p0046;

import java.util.ArrayList;
import java.util.List;

/**
 * 执行用时：1 ms, 在所有 Java 提交中击败了 96.64% 的用户
 * 内存消耗：38.7 MB, 在所有 Java 提交中击败了 48.52% 的用户
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
            if (!flag[i]) {
                flag[i] = true;
                ans.add(nums[i]);
                helper(nums, n + 1);
                ans.remove(ans.size() - 1);
                flag[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }

        flag = new boolean[nums.length];
        helper(nums, 0);
        return res;
    }
}
