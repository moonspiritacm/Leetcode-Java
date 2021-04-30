package com.moonspirit.leetcode.p0633;

/**
 * 双指针。O(n^0.5) O(1)
 */
class SolutionB {
    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }

        long a = 0;
        long b = (long) Math.sqrt(c);
        while (a <= b) {
            long num = a * a + b * b;
            if (num < c) {
                a++;
            } else if (num > c) {
                b--;
            } else {
                return true;
            }
        }
        return false;
    }
}
