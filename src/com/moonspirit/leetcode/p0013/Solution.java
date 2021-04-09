package com.moonspirit.leetcode.p0013;

import java.util.HashMap;
import java.util.Map;

/**
 * 编程练习。O(n) O(1)
 */
class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int num = 0;
        char[] chs = s.toCharArray();
        Map<Character, Integer> dict = new HashMap<>();
        dict.put('I', 1);
        dict.put('V', 5);
        dict.put('X', 10);
        dict.put('L', 50);
        dict.put('C', 100);
        dict.put('D', 500);
        dict.put('M', 1000);
        for (int i = 0; i < chs.length - 1; i++) {
            int n1 = dict.get(chs[i]);
            int n2 = dict.get(chs[i + 1]);
            if (n1 < n2) {
                num -= n1;
            } else {
                num += n1;
            }
        }
        num += dict.get(chs[chs.length - 1]);
        return num;
    }
}
