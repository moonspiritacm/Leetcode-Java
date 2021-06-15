package com.moonspirit.leetcode.p0006;

/**
 * 逐行打印。O(n) O(n)
 */
class SolutionB {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows < 2 || s.length() <= numRows) {
            return s;
        }

        int length = 2 * numRows - 2;
        char[] chs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < chs.length; j += length) {
                sb.append(chs[j + i]);
                if (i != 0 && i != numRows - 1 && j + length - i < chs.length) {
                    sb.append(chs[j + length - i]);
                }
            }
        }
        return sb.toString();
    }
}
