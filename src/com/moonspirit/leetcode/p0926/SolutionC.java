package com.moonspirit.leetcode.p0926;

/**
 * 存储优化。O(n) O(1)
 */
class SolutionC {
    public int minFlipsMonoIncr(String S) {
        if (S == null || S.length() < 2) {
            return 0;
        }

        int n = S.length();
        char[] chs = S.toCharArray();
        int[][] dp = new int[2][2];
        for (int i = 1; i <= n; i++) {
            if (chs[i - 1] == '0') {
                dp[i % 2][0] = dp[(i - 1) % 2][0];
                dp[i % 2][1] = Math.min(dp[(i - 1) % 2][0], dp[(i - 1) % 2][1]) + 1;
            } else {
                dp[i % 2][0] = dp[(i - 1) % 2][0] + 1;
                dp[i % 2][1] = Math.min(dp[(i - 1) % 2][0], dp[(i - 1) % 2][1]);
            }
        }
        return Math.min(dp[n % 2][0], dp[n % 2][1]);
    }
}
