package com.moonspirit.leetcode.p0052;

/**
 * 回溯+位运算。O(n!) O(n)
 */
class SolutionB {
    private int backtrace(int i, int n, int col, int right, int left) {
        if (i == n) {
            return 1;
        }

        int res = 0;
        int pos = ((1 << n) - 1) & (~(col | right | left));
        while (pos != 0) {
            int tmp = pos & (-pos);
            res += backtrace(i + 1, n, col | tmp, (right | tmp) >>> 1, (left | tmp) << 1);
            pos = pos & (pos - 1);
        }
        return res;
    }

    public int totalNQueens(int n) {
        if (n < 1) {
            return 0;
        }

        return backtrace(0, n, 0, 0, 0);
    }
}
