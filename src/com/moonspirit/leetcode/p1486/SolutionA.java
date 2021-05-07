package com.moonspirit.leetcode.p1486;

/**
 * 模拟。O(n) O(1)
 */
class SolutionA {
    public int xorOperation(int n, int start) {
        if (n <= 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res ^= start + 2 * i;
        }
        return res;
    }
}
