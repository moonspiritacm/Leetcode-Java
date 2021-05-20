package com.moonspirit.leetcode.p0473;

/**
 * 回溯。O(4^n) O(n)
 */
class SolutionA {
    private boolean backtrace(int[] matchsticks, int[] tricks, int n, int avg) {
        if (n == matchsticks.length) {
            return tricks[0] == tricks[1] && tricks[0] == tricks[2] && tricks[0] == tricks[3];
        }

        for (int i = 0; i < 4; i++) {
            if (tricks[i] + matchsticks[n] <= avg) {
                tricks[i] += matchsticks[n];
                if (backtrace(matchsticks, tricks, n + 1, avg)) {
                    return true;
                }
                tricks[i] -= matchsticks[n];
            }
        }
        return false;
    }

    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4) {
            return false;
        }

        int sum = 0;
        for (int num : matchsticks) {
            sum += num;
        }
        if (sum % 4 != 0) {
            return false;
        }

        int[] tricks = new int[4];
        return backtrace(matchsticks, tricks, 0, sum / 4);
    }
}
