package com.moonspirit.leetcode.p0058;

/**
 * 执行用时：1 ms, 在所有 Java 提交中击败了 38.63% 的用户
 * 内存消耗：
 * 36.8 MB
 * , 在所有 Java 提交中击败了
 * 58.16%
 * 的用户
 */
class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        String[] strs = s.split(" ");
        if (strs.length == 0) {
            return 0;
        }
        String str = strs[strs.length - 1];
        return str.length();
    }
}
