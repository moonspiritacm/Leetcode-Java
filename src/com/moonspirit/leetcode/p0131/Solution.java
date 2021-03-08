package com.moonspirit.leetcode.p0131;

import java.util.ArrayList;
import java.util.List;

/**
 * 简单回溯。O(n^2*2^n) O(n)
 * 枚举所有可能的分割方法并加以判断。
 * 假设当前搜索到字符串的第i个字符，[0, i-1]的所有字符已经被分割成若干个回文串，接下来枚举下一个回文串的右边界j。
 * 如果找到下一个回文串，则将此字符串加入结果集，进行下一层搜索；
 * 如果未找到下一个回文串，则回溯到上一层，同时将上一个结果移除结果集，恢复现场。
 * <p>
 * 执行用时：9 ms, 在所有 Java 提交中击败了 90.70% 的用户
 * 内存消耗：52.4 MB, 在所有 Java 提交中击败了 48.00% 的用户
 */
class Solution {
    private List<List<String>> res = new ArrayList<>();

    private boolean isHuiWen(char[] chs, int l, int r) {
        while (l <= r) {
            if (chs[l++] != chs[r--]) {
                return false;
            }
        }
        return true;
    }

    private void helper(char[] chs, int start, List<String> ans) {
        if (start >= chs.length) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = start; i < chs.length; i++) {
            if (isHuiWen(chs, start, i)) {
                ans.add(new String(chs, start, i - start + 1));
                helper(chs, i + 1, ans);
                ans.remove(ans.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return res;
        }
        helper(s.toCharArray(), 0, new ArrayList<>());
        return res;
    }
}
