package com.moonspirit.leetcode.p0648;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 暴力搜索。O(∑w^2) O(n)
 */
class Solution1 {
    public String replaceWords(List<String> dictionary, String sentence) {
        if (dictionary == null || dictionary.size() == 0 || sentence == null || sentence.length() == 0) {
            return sentence;
        }

        Set<String> set = new HashSet<>();
        int len = 0;
        for (String str : dictionary) {
            set.add(str);
            len = Math.max(len, str.length());
        }

        String[] strs = sentence.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            boolean flag = false;
            for (int i = 1; i <= str.length() && i <= len && !flag; i++) {
                if (set.contains(str.substring(0, i))) {
                    sb.append(str, 0, i).append(" ");
                    flag = true;
                }
            }
            if (!flag) {
                sb.append(str).append(" ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
