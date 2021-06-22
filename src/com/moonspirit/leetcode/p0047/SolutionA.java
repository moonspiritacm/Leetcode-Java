package com.moonspirit.leetcode.p0047;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 排列去重。
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
            if (!flags[i] && (i == 0 || flags[i - 1] || nums[i] != nums[i - 1])) {
                flags[i] = true;
                ans.add(nums[i]);
                backtrace(nums, flags, num + 1);
                ans.remove(ans.size() - 1);
                flags[i] = false;
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        res = new ArrayList<>();
        ans = new ArrayList<>();
        backtrace(nums, new boolean[nums.length], 0);
        return res;
    }
}
