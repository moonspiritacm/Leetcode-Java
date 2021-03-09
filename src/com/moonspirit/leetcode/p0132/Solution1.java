package com.moonspirit.leetcode.p0132;

/**
 * 记忆化搜索。O(n^2) O(n^2)
 * <p>
 * 执行用时：11 ms, 在所有 Java 提交中击败了 75.48% 的用户
 * 内存消耗：37.8 MB, 在所有 Java 提交中击败了 75.46% 的用户
 */
class Solution1 {
    private int[] f;
    private boolean[][] dp;

    private void helper(char[] chs, int i) {
        if (dp[0][i]) {
            f[i] = 0;
            return;
        }
        f[i] = Integer.MAX_VALUE;
        for (int j = 0; j < i; j++) {
            if (dp[j + 1][i]) {
                if (f[j] == -1) {
                    helper(chs, j);
                }
                f[i] = Math.min(f[i], f[j] + 1);
            }
        }
    }

    public int minCut(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }

        char[] chs = s.toCharArray();
        f = new int[chs.length];
        dp = new boolean[chs.length][chs.length];
        for (int i = 0; i < chs.length; i++) {
            f[i] = -1;
        }
        for (int i = chs.length - 1; i >= 0; i--) {
            for (int j = 0; j < chs.length; j++) {
                if (i >= j) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = (chs[i] == chs[j]) && dp[i + 1][j - 1];
                }
            }
        }
        helper(chs, chs.length - 1);
        return f[chs.length - 1];
    }
}
