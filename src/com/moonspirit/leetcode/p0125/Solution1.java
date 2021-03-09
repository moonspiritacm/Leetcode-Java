package com.moonspirit.leetcode.p0125;

/**
 * 判读回文数——递归。O(n) O(1)
 * <p>
 * 执行用时：11 ms, 在所有 Java 提交中击败了 15.61% 的用户
 * 内存消耗：51.3 MB, 在所有 Java 提交中击败了 5.07% 的用户
 */
class Solution1 {
    private boolean isPalindrome(char[] chs, int l, int r) {
        if (l > r) {
            return true;
        }
        if (!Character.isLetterOrDigit(chs[l])) {
            return isPalindrome(chs, l + 1, r);
        }
        if (!Character.isLetterOrDigit(chs[r])) {
            return isPalindrome(chs, l, r - 1);
        }
        if (chs[l] == chs[r] || Character.toLowerCase(chs[l]) == Character.toLowerCase(chs[r])) {
            return isPalindrome(chs, l + 1, r - 1);
        }
        return false;
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        return isPalindrome(s.toCharArray(), 0, s.length() - 1);
    }
}
