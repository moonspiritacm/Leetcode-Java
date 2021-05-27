package com.moonspirit.leetcode.p0455;

import java.util.Arrays;

/**
 * 贪心算法。O(mlogm+nlogn) O(logm+logn)
 */
class SolutionA {
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || g.length == 0 || s == null || s.length == 0) {
            return 0;
        }

        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        int n = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                i++;
                j++;
                n++;
            } else {
                j++;
            }
        }
        return n;
    }
}
