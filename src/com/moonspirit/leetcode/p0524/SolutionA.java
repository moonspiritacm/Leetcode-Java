package com.moonspirit.leetcode.p0524;

import java.util.List;

/**
 * 逐字典匹配。O(nl) O(l)
 */
class SolutionA {
    public String findLongestWord(String s, List<String> dictionary) {
        if (s == null || s.length() == 0 || dictionary == null || dictionary.size() == 0) {
            return "";
        }

        int len = 0;
        String res = "";
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
                if (chc.length > len || chc.length == len && str.compareTo(res) < 0) {
                    len = chc.length;
                    res = str;
                }
            }
        }
        return res;
    }
}
