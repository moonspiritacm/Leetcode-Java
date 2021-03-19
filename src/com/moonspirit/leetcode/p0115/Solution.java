package com.moonspirit.leetcode.p0115;

/**
 * 暴力搜索。
 */
class Solution {
    private int cnt;

    private void helper(char[] s, char[] t, int n, int i) {
        if (n == t.length) {
            cnt++;
            return;
        }

        for (; i < s.length; i++) {
            if (s[i] == t[n]) {
                helper(s, t, n + 1, i + 1);
            }
        }
    }

    public int numDistinct(String s, String t) {
        if (t == null || t.length() == 0) {
            return 1;
        }
        if (s == null || s.length() == 0 || s.length() < t.length()) {
            return 0;
        }

        helper(s.toCharArray(), t.toCharArray(), 0, 0);
        return cnt;
    }
}
