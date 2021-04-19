package com.moonspirit.leetcode.p0926;

/**
 * 记忆化递归。O(n) O(n)
 */
class SolutionD {
    private int[][] dp;

    private int[] helper(char[] chs, int n) {
        if (n < 0) {
            return new int[]{0, 0};
        }
        if (dp[n][0] != -1) {
            return dp[n];
        }

        int[] res = helper(chs, n - 1);
        if (chs[n] == '0') {
            dp[n][0] = res[0];
            dp[n][1] = Math.min(res[0], res[1]) + 1;
        } else {
            dp[n][0] = res[0] + 1;
            dp[n][1] = Math.min(res[0], res[1]);
        }
        return dp[n];
    }

    public int minFlipsMonoIncr(String S) {
        if (S == null || S.length() < 2) {
            return 0;
        }

        int n = S.length();
        char[] chs = S.toCharArray();
        dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        int[] res = helper(chs, n - 1);
        return Math.min(res[0], res[1]);
    }
}
