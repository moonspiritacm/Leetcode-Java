package com.moonspirit.leetcode.p0926;

/**
 * 动态规划。O(n) O(n)
 */
class SolutionB {
    public int minFlipsMonoIncr(String S) {
        if (S == null || S.length() < 2) {
            return 0;
        }

        int n = S.length();
        char[] chs = S.toCharArray();
        int[][] dp = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            if (chs[i - 1] == '0') {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1;
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]);
            }
        }
        return Math.min(dp[n][0], dp[n][1]);
    }
}
