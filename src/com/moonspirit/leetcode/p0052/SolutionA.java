package com.moonspirit.leetcode.p0052;

/**
 * 回溯+标记数组。O(n!) O(n)
 */
class SolutionA {
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

    private int backtrace(int i) {
        if (i == n) {
            return 1;
        }

        int res = 0;
        for (int j = 0; j < n; j++) {
            if (!isFull(i, j)) {
                update(i, j, true);
                res += backtrace(i + 1);
                update(i, j, false);
            }
        }
        return res;
    }

    public int totalNQueens(int n) {
        if (n < 1) {
            return 0;
        }

        this.col = new boolean[n];
        this.x1 = new boolean[2 * n - 1];
        this.x2 = new boolean[2 * n - 1];
        this.n = n;
        return backtrace(0);
    }
}
