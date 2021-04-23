package com.moonspirit.leetcode.p0028;

/**
 * 滚动哈希。O(n) O(1)
 */
class SolutionB {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack == null || haystack.length() < needle.length()) {
            return -1;
        }

        char[] c1 = haystack.toCharArray();
        char[] c2 = needle.toCharArray();
        long h1 = 0;
        long h2 = 0;
        long mul = 1;
        long modulus = Integer.MAX_VALUE;
        for (int i = 1; i <= c2.length; i++) {
            mul = (mul * 31) % modulus;
        }
        for (int i = 0; i < c2.length; i++) {
            h1 = (h1 * 31 + c1[i] - 'a') % modulus;
            h2 = (h2 * 31 + c2[i] - 'a') % modulus;
        }
        if (h1 == h2) {
            return 0;
        }

        for (int i = 1; i < c1.length - c2.length + 1; i++) {
            h1 = (h1 * 31 - (c1[i - 1] - 'a') * mul + (c1[i + c2.length - 1] - 'a')) % modulus;
            if (h1 == h2) {
                return i;
            }
        }
        return -1;
    }
}
