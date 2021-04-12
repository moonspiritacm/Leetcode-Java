package com.moonspirit.leetcode.p0014;

/**
 * 横向扫描。O(mn) O(1)
 */
class Solution1 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int l = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            l = Math.min(l, strs[i].length());
            for (int j = 0; j < l; j++) {
                if (strs[i - 1].charAt(j) != strs[i].charAt(j)) {
                    l = j;
                    break;
                }
            }
        }
        return strs[0].substring(0, l);
    }
}
