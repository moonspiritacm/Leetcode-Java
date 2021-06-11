package com.moonspirit.leetcode.p1880;

/**
 * 模拟。O(n) O(1)
 */
class SolutionA {
    private int str2num(char[] chs) {
        int res = 0;
        for (int i = 0; i < chs.length; i++) {
            res = res * 10 + chs[i] - 'a';
        }
        return res;
    }

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        if (firstWord == null || firstWord.length() == 0 || secondWord == null || secondWord.length() == 0 || targetWord == null || targetWord.length() == 0) {
            return false;
        }

        int a = str2num(firstWord.toCharArray());
        int b = str2num(secondWord.toCharArray());
        int c = str2num(targetWord.toCharArray());
        return c == a + b;
    }
}
