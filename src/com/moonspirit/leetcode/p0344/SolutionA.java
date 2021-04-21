package com.moonspirit.leetcode.p0344;

/**
 * 编程练习。O(n) O(1)
 */
class SolutionA {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        for (int i = 0; i < s.length / 2; i++) {
            char tmp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = tmp;
        }
    }
}
