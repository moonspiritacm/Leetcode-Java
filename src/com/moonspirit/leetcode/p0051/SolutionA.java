package com.moonspirit.leetcode.p0051;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯+标记数组。O(n!) O(n)
 */
class SolutionA {
    private List<List<String>> res;
    private List<String> ans;
    private String[] dict;
    private boolean[] col;
    private boolean[] x1;
    private boolean[] x2;
    private int n;

    private boolean isFull(int i, int j) {
        return col[j] || x1[i + j] || x2[i - j + n - 1];
    }

    private void update(int i, int j, boolean flag) {
        col[j] = flag;
        x1[i + j] = flag;
        x2[i - j + n - 1] = flag;
    }

    private void backtrace(int i) {
        if (n == i) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int j = 0; j < n; j++) {
            if (!isFull(i, j)) {
                update(i, j, true);
                ans.add(dict[j]);
                backtrace(i + 1);
                ans.remove(ans.size() - 1);
                update(i, j, false);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }

        this.res = new ArrayList<>();
        this.ans = new ArrayList<>();
        this.dict = new String[n];
        this.col = new boolean[n];
        this.x1 = new boolean[2 * n - 1];
        this.x2 = new boolean[2 * n - 1];
        this.n = n;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('.');
        }
        for (int i = 0; i < n; i++) {
            sb.replace(i, i + 1, "Q");
            dict[i] = sb.toString();
            sb.replace(i, i + 1, ".");
        }
        backtrace(0);
        return res;
    }
}
