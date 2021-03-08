package com.moonspirit.leetcode.p0131;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯+记忆化搜索。O(n2^n) O(n)
 * 通过记忆化搜索，判断[i, j]是否为回文串的均摊时间复杂度降为O(1)，与动态规划等效。
 * <p>
 * 执行用时：8 ms, 在所有 Java 提交中击败了 94.08% 的用户
 * 内存消耗：52.1 MB, 在所有 Java 提交中击败了 62.28% 的用户
 */
class Solution2 {
    private List<List<String>> res = new ArrayList<>();
    private int[][] dp;

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return res;
        }

        char[] chs = s.toCharArray();
        dp = new int[chs.length][chs.length];
        helper(s.toCharArray(), 0, new ArrayList<>());
        return res;
    }

    private int isPalindrome(char[] chs, int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        if (i >= j) {
            dp[i][j] = 1;
        } else if (chs[i] == chs[j]) {
            dp[i][j] = isPalindrome(chs, i + 1, j - 1);
        } else {
            dp[i][j] = -1;
        }
        return dp[i][j];
    }

    private void helper(char[] chs, int start, List<String> ans) {
        if (start >= chs.length) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = start; i < chs.length; i++) {
            if (isPalindrome(chs, start, i) == 1) {
                ans.add(new String(chs, start, i - start + 1));
                helper(chs, i + 1, ans);
                ans.remove(ans.size() - 1);
            }
        }
    }
}
