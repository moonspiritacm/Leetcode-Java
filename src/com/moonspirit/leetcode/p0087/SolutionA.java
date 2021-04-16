package com.moonspirit.leetcode.p0087;

/**
 * 暴力搜索，超时。
 */
class SolutionA {
    private boolean check(String s1, String s2) {
        int[] n1 = new int[26];
        int[] n2 = new int[26];
        for (char ch : s1.toCharArray()) {
            n1[ch - 'a']++;
        }
        for (char ch : s2.toCharArray()) {
            n2[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (n1[i] != n2[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s1.length() == 0) {
            return s2 == null || s2.length() == 0;
        }
        if (s1.length() != s2.length() || !check(s1, s2)) {
            return false;
        }
        if (s1.length() == 1) {
            return true;
        }

        for (int i = 1; i < s1.length(); i++) {
            String[] s1s = {s1.substring(0, i), s1.substring(i)};
            String[] s2s = {s2.substring(0, i), s2.substring(i), s2.substring(s1.length() - i), s2.substring(0, s1.length() - i)};
            if (isScramble(s1s[0], s2s[0]) && isScramble(s1s[1], s2s[1]) || isScramble(s1s[0], s2s[2]) && isScramble(s1s[1], s2s[3])) {
                return true;
            }
        }
        return false;
    }
}
