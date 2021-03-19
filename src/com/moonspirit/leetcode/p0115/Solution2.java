package com.moonspirit.leetcode.p0115;

/**
 * 动态规划（空间优化）。O(n^2) O(n)
 * 第i行状态更新仅需要当前行dp[i][j-1]和上一行dp[i-1][j-1]的状态。
 */
class Solution2 {
    public static void main(String[] args) {
        int a =new Solution2().numDistinct("rabbbit", "rabbit");
        System.out.println(a);
    }

    public int numDistinct(String s, String t) {
        if (t == null || t.length() == 0) {
            return 1;
        }
        if (s == null || s.length() == 0 || s.length() < t.length()) {
            return 0;
        }

        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        int[][] dp = new int[2][chs.length + 1];
        for (int j = 0; j <= chs.length; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= cht.length; i++) {
            for (int j = 1; j <= chs.length; j++) {
                if (cht[i - 1] == chs[j - 1]) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j - 1] + dp[i % 2][j - 1];
                } else {
                    dp[i % 2][j] = dp[i % 2][j - 1];
                }
                System.out.printf("%d ", dp[i%2][j]);
            }
            System.out.println();
        }
        return dp[cht.length % 2][chs.length];
    }
}
