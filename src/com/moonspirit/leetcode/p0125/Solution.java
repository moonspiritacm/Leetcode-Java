package com.moonspirit.leetcode.p0125;

/**
 * 判读回文数——迭代。O(n) O(1)
 * <p>
 * 执行用时：3 ms, 在所有 Java 提交中击败了 92.93% 的用户
 * 内存消耗：38.8 MB, 在所有 Java 提交中击败了 19.62% 的用户
 */
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }

        int l = 0;
        int r = s.length() - 1;
        char[] chs = s.toCharArray();
        while (l < r) {
            if (!Character.isLetterOrDigit(chs[l])) {
                l++;
            } else if (!Character.isLetterOrDigit(chs[r])) {
                r--;
            } else if (chs[l] == chs[r] || Character.toLowerCase(chs[l]) == Character.toLowerCase(chs[r])) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}
