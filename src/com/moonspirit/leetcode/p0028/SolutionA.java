package com.moonspirit.leetcode.p0028;

/**
 * 暴力搜索。O((N-L)L) O(1)
 */
class SolutionA {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack == null || haystack.length() < needle.length()) {
            return -1;
        }

        char[] c1 = haystack.toCharArray();
        char[] c2 = needle.toCharArray();
        for (int i = 0; i <= c1.length - c2.length; i++) {
            if (c1[i] == c2[0]) {
                boolean flag = true;
                for (int j = 1; j < c2.length; j++) {
                    if (c1[i + j] != c2[j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return i;
                }
            }
        }
        return -1;
    }
}
