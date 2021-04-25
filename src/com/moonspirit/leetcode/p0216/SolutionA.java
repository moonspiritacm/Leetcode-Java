package com.moonspirit.leetcode.p0216;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯+剪枝。O(k*C(k,9)) O(n)
 */
class SolutionA {
    private List<List<Integer>> res;
    private List<Integer> ans;

    private void backtrace(int k, int n, int index) {
        if (n == 0 && k == 0) {
            res.add(new ArrayList<>(ans));
            return;
        }
        if (n <= 0 || k <= 0 || index > 9) {
            return;
        }

        for (int i = index; i <= 9; i++) {
            if (i <= n) {
                ans.add(i);
                backtrace(k - 1, n - i, i + 1);
                ans.remove(ans.size() - 1);
            } else {
                break;
            }
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n <= 0 || k > 9) {
            return new ArrayList<>();
        }

        res = new ArrayList<>();
        ans = new ArrayList<>();
        backtrace(k, n, 1);
        return res;
    }
}
