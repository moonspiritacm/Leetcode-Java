package com.moonspirit.leetcode.p0926;

/**
 * 遍历分割点。O(n) O(n)
 */
class SolutionA {
    public int minFlipsMonoIncr(String S) {
        if (S == null || S.length() < 2) {
            return 0;
        }

        int n = S.length();
        char[] chs = S.toCharArray();
        int[] l = new int[n];
        int[] r = new int[n];
        l[0] = chs[0] - '0';
        r[n - 1] = '1' - chs[n - 1];
        for (int i = 1; i < n; i++) {
            l[i] = chs[i] - '0' + l[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            r[i] = '1' - chs[i] + r[i + 1];
        }
        int res = Math.min(l[n - 1], r[0]);
        for (int i = 0; i < n - 1; i++) {
            res = Math.min(res, l[i] + r[i + 1]);
        }
        return res;
    }
}
