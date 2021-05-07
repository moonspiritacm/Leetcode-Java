package com.moonspirit.leetcode.p0007;

/**
 * 模拟。O(log|x|) O(1)
 */
class SolutionA {
    public int reverse(int x) {
        int y = 0;
        while (x != 0) {
            if (y > Integer.MAX_VALUE / 10 || (y == Integer.MAX_VALUE / 10 && x % 10 > Integer.MAX_VALUE % 10)) {
                return 0;
            }
            if (y < Integer.MIN_VALUE / 10 || (y == Integer.MIN_VALUE / 10 && x % 10 < Integer.MIN_VALUE % 10)) {
                return 0;
            }
            y = y * 10 + x % 10;
            x /= 10;
        }
        return y;
    }
}
