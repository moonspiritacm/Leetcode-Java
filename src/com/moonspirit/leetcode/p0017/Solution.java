package com.moonspirit.leetcode.p0017;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯。O(3^m×4^n) O(m+n)
 * 利用回溯算法寻找所有的可行解。
 */
class Solution {
    private List<String> res = new ArrayList<>();
    private String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private void backtrace(char[] chs, int index, StringBuilder ans) {
        if (chs.length == index) {
            res.add(new String(ans));
            return;
        }

        char[] elements = dict[chs[index] - '0'].toCharArray();
        for (char ch : elements) {
            ans.append(ch);
            backtrace(chs, index + 1, ans);
            ans.deleteCharAt(ans.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }

        backtrace(digits.toCharArray(), 0, new StringBuilder());
        return res;
    }
}
