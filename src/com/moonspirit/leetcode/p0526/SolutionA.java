package com.moonspirit.leetcode.p0526;

/**
 * 回溯。
 */
class SolutionA {
    private int res;
    private boolean[] flag;

    private void dfs(int c, int n) {
        if (c > n) {
            res++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!flag[i] && (i % c == 0 || c % i == 0)) {
                flag[i] = true;
                dfs(c + 1, n);
                flag[i] = false;
            }
        }
    }

    public int countArrangement(int n) {
        if (n < 1) {
            return 0;
        }

        res = 0;
        flag = new boolean[n + 1];
        dfs(1, n);
        return res;
    }
}
