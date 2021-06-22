package com.moonspirit.leetcode.p0046;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯。
 */
class SolutionA {
    private List<List<Integer>> res;
    private List<Integer> ans;

    private void backtrace(int[] nums, boolean[] flags, int num) {
        if (num == nums.length) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!flags[i]) {
                flags[i] = true;
                ans.add(nums[i]);
                backtrace(nums, flags, num + 1);
                ans.remove(ans.size() - 1);
                flags[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        res = new ArrayList<>();
        ans = new ArrayList<>();
        backtrace(nums, new boolean[nums.length], 0);
        return res;
    }
}
