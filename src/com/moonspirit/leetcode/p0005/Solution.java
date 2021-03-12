package com.moonspirit.leetcode.p0005;

/**
 * 动态规划。O(n^2) O(n^2)
 * dp[i][j]表示[i, j]是否为回文串：当i≥j时，空串或单字符，dp[i][j] = true；当i<j时，dp[i][j] = (s[i] == s[j]) && dp[i + 1][j - 1]。
 * 注意动态规划状态更新顺序。当前状态依赖于下一行前一列状态，故行遍历为倒序，列遍历为正序。
 * <p>
 * 执行用时：267 ms, 在所有 Java 提交中击败了 37.71% 的用户
 * 内存消耗：42.7 MB, 在所有 Java 提交中击败了 34.66% 的用户
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int l = 0;
        int r = 0;
        int res = 0;
        char[] chs = s.toCharArray();
        boolean[][] dp = new boolean[chs.length][chs.length];
        for (int i = chs.length - 1; i >= 0; i--) {
            for (int j = 0; j < chs.length; j++) {
                if (i >= j) {
                    dp[i][j] = true;
                } else {
                    if ((chs[i] == chs[j]) && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        if (res <= j - i + 1) {
                            res = j - i + 1;
                            l = i;
                            r = j;
                        }
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return s.substring(l, r + 1);
    }
}
