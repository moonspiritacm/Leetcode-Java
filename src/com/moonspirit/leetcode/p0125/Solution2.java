package com.moonspirit.leetcode.p0125;

/**
 * 判读回文数——手工判读。O(n) O(1)
 * <p>
 * 执行用时：2 ms, 在所有 Java 提交中击败了 99.87% 的用户
 * 内存消耗：38.3 MB, 在所有 Java 提交中击败了 89.77% 的用户
 */
class Solution2 {
    private boolean isNotVaild(char ch) {
        return !(ch >= '0' && ch <= '9' || ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z');
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }

        int l = 0;
        int r = s.length() - 1;
        char[] chs = s.toCharArray();
        while (l <= r) {
            if (isNotVaild(chs[l])) {
                l++;
            } else if (isNotVaild(chs[r])) {
                r--;
            } else {
                if (chs[l] >= 'a' && chs[l] <= 'z') {
                    chs[l] -= 32;
                }
                if (chs[r] >= 'a' && chs[r] <= 'z') {
                    chs[r] -= 32;
                }
                if (chs[l] == chs[r]) {
                    l++;
                    r--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
