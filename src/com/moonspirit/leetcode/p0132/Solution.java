package com.moonspirit.leetcode.p0132;

/**
 * 动态规划。O(n^2) O(n^2)
 * f[i]表示[0, i]的最小分割次数。
 * f[i] = min{f[j]} + 1，其中s[j+1, i]是一个回文串。特殊地，如果s[0, i]是回文串，那么f[i] = 0。
 * <p>
 * 执行用时：14 ms, 在所有 Java 提交中击败了 62.92% 的用户
 * 内存消耗：38.1 MB, 在所有 Java 提交中击败了 72.84% 的用户
 */
class Solution {
    public int minCut(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }

        char[] chs = s.toCharArray();
        int[] f = new int[chs.length];
        boolean[][] dp = new boolean[chs.length][chs.length];
        for (int i = chs.length - 1; i >= 0; i--) {
            for (int j = 0; j < chs.length; j++) {
                if (i >= j) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = (chs[i] == chs[j]) && dp[i + 1][j - 1];
                }
            }
        }
        for (int i = 1; i < chs.length; i++) {
            f[i] = Integer.MAX_VALUE;
            if (dp[0][i]) {
                f[i] = 0;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (dp[j + 1][i]) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        return f[chs.length - 1];
    }
}
