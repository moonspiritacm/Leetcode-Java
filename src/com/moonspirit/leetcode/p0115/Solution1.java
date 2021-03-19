package com.moonspirit.leetcode.p0115;

/**
 * 动态规划。O(n^2) O(n^2)
 * dp[i][j]表示t[:i]在s[:j]中出现的次数
 * 1.当s[i]==t[j]时，有两种选择：①使用s[i]，dp[i-1][j-1] ②跳过s[i]，dp[i][j-1]
 * 2.当s[i]!=t[j]时，只能跳过s[i]，dp[i][j-1]
 * 边界情况：
 * 1.当i=0时，t为空序列，对于任意0≤j≤m，dp[0][j]=1;
 * 2.当j=0时，s为空序列，对于任意0<i≤n，dp[i][0]=0;
 * <p>
 * 执行用时：2 ms, 在所有 Java 提交中击败了 97.64% 的用户
 * 内存消耗：37 MB, 在所有 Java 提交中击败了 19.91% 的用户
 */
class Solution1 {

    public static void main(String[] args) {
        int a =new Solution1().numDistinct("rabbbit", "rabbit");
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
        int[][] dp = new int[cht.length + 1][chs.length + 1];
        for (int j = 0; j <= chs.length; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= cht.length; i++) {
            for (int j = 1; j <= chs.length; j++) {
                if (cht[i - 1] == chs[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
                System.out.printf("%d ", dp[i][j]);
            }
            System.out.println();
        }
        return dp[cht.length][chs.length];
    }
}
