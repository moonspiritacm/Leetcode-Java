package com.moonspirit.leetcode.p0524;

import java.util.List;

/**
 * 排序后逐字典匹配。O(nl*logn+n*l) O(logn)
 */
class SolutionB {
    public String findLongestWord(String s, List<String> dictionary) {
        if (s == null || s.length() == 0 || dictionary == null || dictionary.size() == 0) {
            return "";
        }

        dictionary.sort((a, b) -> {
            if (a.length() != b.length()) {
                return b.length() - a.length();
            } else {
                return a.compareTo(b);
            }
        });
        char[] chs = s.toCharArray();
        for (String str : dictionary) {
            char[] chc = str.toCharArray();
            int i = 0;
            int j = 0;
            while (i < chs.length && j < chc.length) {
                if (chs[i] == chc[j]) {
                    i++;
                    j++;
                } else {
                    i++;
                }
            }
            if (j == chc.length) {
                return str;
            }
        }
        return "";
    }
}
