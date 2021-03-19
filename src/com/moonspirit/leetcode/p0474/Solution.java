package com.moonspirit.leetcode.p0474;

class Solution {
    private int cntZero(String str) {
        int cnt = 0;
        char[] chs = str.toCharArray();
        for (char ch : chs) {
            if (ch == '0') {
                cnt++;
            }
        }
        return cnt;
    }

    public int findMaxForm(String[] strs, int m, int n) {
        if (m <= 0 || n <= 0 || strs == null || strs.length == 0) {
            return 0;
        }

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= strs.length; i++) {
            int zero = cntZero(strs[i - 1]);
            int one = strs[i - 1].length() - zero;




            if (zero + dp[i][1] <= m && one + dp[i][2] <= n) {
                dp[i][0] = 1;
                dp[i][1] = zero;
                dp[i][2] = one;
            }
            for (int j = 1; j < i; j++) {
                if (zero + dp[j][1] <= m && one + dp[j][2] <= n) {
                    if (dp[j][0] + 1 > dp[i][0]) {
                        dp[i][0] = dp[j][0] + 1;
                        dp[i][1] = zero + dp[j][1];
                        dp[i][2] = one + dp[j][2];
                    }
                    if (dp[j][0] + 1 == dp[i][0] && dp[j][1] + zero < dp[i][1] && dp[j][2] + one < dp[i][1]) {
                        dp[i][0] = dp[j][0] + 1;
                        dp[i][1] = zero + dp[j][1];
                        dp[i][2] = one + dp[j][2];
                    }
                }
            }
            System.out.printf("%d %d %d\n", dp[i][0], dp[i][1], dp[i][2]);
            res = Math.max(res, dp[i][0]);
        }
        return res;
    }
}