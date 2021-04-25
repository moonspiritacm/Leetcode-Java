package com.moonspirit.leetcode.p0040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯+剪枝。O(n*2^n) O(n)
 */
class SolutionA {
    private List<List<Integer>> res;
    private List<Integer> ans;

    private void backtrace(int[] candidates, int target, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(ans));
            return;
        }
        if (index == candidates.length) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] <= target) {
                ans.add(candidates[i]);
                backtrace(candidates, target - candidates[i], i + 1);
                ans.remove(ans.size() - 1);
            } else {
                break;
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target < 0) {
            return new ArrayList<>();
        }

        res = new ArrayList<>();
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrace(candidates, target, 0);
        return res;
    }
}
