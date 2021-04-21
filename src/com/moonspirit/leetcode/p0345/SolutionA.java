package com.moonspirit.leetcode.p0345;

import java.util.HashSet;
import java.util.Set;

/**
 * 编程练习。O(n) O(1)
 */
class SolutionA {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        char[] chs = s.toCharArray();
        int l = 0;
        int r = chs.length - 1;
        while (l < r) {
            if (!set.contains(chs[l])) {
                l++;
                continue;
            } else if (!set.contains(chs[r])) {
                r--;
                continue;
            } else {
                char tmp = chs[l];
                chs[l] = chs[r];
                chs[r] = tmp;
                l++;
                r--;
            }
        }
        return new String(chs);
    }
}
