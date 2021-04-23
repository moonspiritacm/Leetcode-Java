package com.moonspirit.leetcode.p0051;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯+位运算。O(n!) O(n)
 */
class SolutionB {
    private List<List<String>> res;
    private List<String> ans;
    private String[] dict;

    private void backtrace(int i, int n, int col, int left, int right) {
        if (i == n) {
            res.add(new ArrayList<>(ans));
            return;
        }

        int pos = ((1 << n) - 1) & (~(col | left | right));
        while (pos != 0) {
            int tmp = pos & (-pos);
            for (int k = 0; k < n; k++) {
                if ((tmp & (1 << k)) != 0) {
                    ans.add(dict[k]);
                    break;
                }
            }
            backtrace(i + 1, n, col | tmp, (left | tmp) << 1, (right | tmp) >>> 1);
            ans.remove(ans.size() - 1);
            pos = pos & (pos - 1);
        }
    }

    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }

        res = new ArrayList<>();
        ans = new ArrayList<>();
        dict = new String[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(".");
        }
        for (int i = 0; i < n; i++) {
            sb.replace(i, i + 1, "Q");
            dict[i] = new String(sb);
            sb.replace(i, i + 1, ".");
        }
        backtrace(0, n, 0, 0, 0);
        return res;
    }
}
