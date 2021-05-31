package com.moonspirit.leetcode.p0046;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯。
 */
class SolutionA {
    private List<List<Integer>> res;
    private List<Integer> ans;
    private boolean[] flag;

    private void backtrace(int[] nums, int n) {
        if (n == nums.length) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!flag[i]) {
                flag[i] = true;
                ans.add(nums[i]);
                backtrace(nums, n + 1);
                ans.remove(ans.size() - 1);
                flag[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        res = new ArrayList<>();
        ans = new ArrayList<>();
        flag = new boolean[nums.length];
        backtrace(nums, 0);
        return res;
    }
}
