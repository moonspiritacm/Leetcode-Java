package com.moonspirit.leetcode.p0473;

import java.util.Arrays;

/**
 * 回溯+剪枝。O(4^n) O(n)
 */
class SolutionB {
    private boolean backtrace(int[] matchsticks, int[] tricks, int n, int avg) {
        if (n == -1) {
            return tricks[0] == tricks[1] && tricks[0] == tricks[2] && tricks[0] == tricks[3];
        }

        for (int i = 0; i < 4; i++) {
            if (tricks[i] + matchsticks[n] <= avg) {
                tricks[i] += matchsticks[n];
                if (backtrace(matchsticks, tricks, n - 1, avg)) {
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

        Arrays.sort(matchsticks);
        int[] tricks = new int[4];
        return backtrace(matchsticks, tricks, matchsticks.length - 1, sum / 4);
    }
}
