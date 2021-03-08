package com.moonspirit.leetcode.p0131;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯+动态规划。O(n2^n) O(n)
 * 通过动态规划预处理，判断[i, j]是否为回文串的时间复杂度降为O(1)。
 * dp[i][j]表示[i, j]是否为回文串：当i≥j时，空串或单字符，dp[i][j] = true；当i<j时，dp[i][j] = (s[i] == s[j]) && dp[i + 1][j - 1]。
 * 注意动态规划状态更新顺序。当前状态依赖于下一行前一列状态，故行遍历为倒序，列遍历为正序。
 * <p>
 * 执行用时：8 ms, 在所有 Java 提交中击败了 94.08% 的用户
 * 内存消耗：52.3 MB, 在所有 Java 提交中击败了 54.89% 的用户
 */
class Solution1 {
    private List<List<String>> res = new ArrayList<>();
    private boolean[][] dp;

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return res;
        }

        char[] chs = s.toCharArray();
        dp = new boolean[chs.length][chs.length];
        for (int i = chs.length - 1; i >= 0; i--) {
            for (int j = 0; j < chs.length; j++) {
                if (i >= j) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = (chs[i] == chs[j]) && dp[i + 1][j - 1];
                }
            }
        }

        helper(s.toCharArray(), 0, new ArrayList<>());
        return res;
    }

    private void helper(char[] chs, int start, List<String> ans) {
        if (start >= chs.length) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = start; i < chs.length; i++) {
            if (dp[start][i]) {
                ans.add(new String(chs, start, i - start + 1));
                helper(chs, i + 1, ans);
                ans.remove(ans.size() - 1);
            }
        }
    }
}
