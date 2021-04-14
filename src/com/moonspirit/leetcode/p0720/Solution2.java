package com.moonspirit.leetcode.p0720;

import java.util.*;

/**
 * 暴力搜索。O(∑w^2) O(∑w^2)
 */
class Solution2 {
    public String longestWord(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }

        String res = "";
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        for (String word : words) {
            if (word.length() > res.length() || word.length() == res.length() && word.compareTo(res) < 0) {
                boolean flag = true;
                for (int i = 1; i <= word.length() && flag; i++) {
                    if (!set.contains(word.substring(0, i))) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    res = word;
                }
            }
        }
        return res;
    }
}
