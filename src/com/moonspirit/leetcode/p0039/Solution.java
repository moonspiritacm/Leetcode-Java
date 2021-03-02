package com.moonspirit.leetcode.p0039;

import java.util.ArrayList;
import java.util.List;

/**
 * 结束条件：
 *    ① 找到目标解 target==0；
 *    ② 穷尽搜索空间 candidates[i] <= target
 * 剪枝一：
 */
class Solution {
    private List<List<Integer>> res;

    private void backtrack(int[] candidates, int target, List<Integer> ans) {
        if (target == 0) {
            res.add(ans);
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                ans.add(candidates[i]);
                backtrack(candidates, target - candidates[i], ans);
                ans.remove(ans.size()-1);
            }
        }

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target <= 0) {
            return null;
        }
        res = new ArrayList<>();
        backtrack(candidates, target, new ArrayList<>());
        return res;
    }
}
