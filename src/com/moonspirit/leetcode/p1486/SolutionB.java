package com.moonspirit.leetcode.p1486;

/**
 * 数学。O(1) O(1)
 */
class SolutionB {
    private int sumXor(int x) {
        if (x % 4 == 0) {
            return x;
        }
        if (x % 4 == 1) {
            return 1;
        }
        if (x % 4 == 2) {
            return x + 1;
        }
        return 0;
    }

    public int xorOperation(int n, int start) {
        if (n <= 0) {
            return 0;
        }

        int s = start >> 1;
        int e = n & start & 1;
        int res = sumXor(s - 1) ^ sumXor(s + n - 1);
        return res << 1 | e;
    }
}
