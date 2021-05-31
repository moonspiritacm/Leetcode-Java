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
    private boolean[] flag;

    private void backtrace(int[] nums, int n) {
        if (n == nums.length) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!flag[i] && (i == 0 || !flag[i - 1] || nums[i - 1] != nums[i])) {
                flag[i] = true;
                ans.add(nums[i]);
                backtrace(nums, n + 1);
                ans.remove(ans.size() - 1);
                flag[i] = false;
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        res = new ArrayList<>();
        ans = new ArrayList<>();
        flag = new boolean[nums.length];
        Arrays.sort(nums);
        backtrace(nums, 0);
        return res;
    }
}
