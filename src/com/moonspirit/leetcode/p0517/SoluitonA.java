package com.moonspirit.leetcode.p0517;

/**
 * 贪心。O(n) O(1)
 */
class SolutionA {
    public int findMinMoves(int[] machines) {
        if (machines == null || machines.length == 0) {
            return -1;
        }
        if (machines.length == 1) {
            return 0;
        }

        int sum = 0;
        for (int machine : machines) {
            sum += machine;
        }
        if (sum % machines.length == 0) {
            int pre = 0;
            int res = 0;
            sum /= machines.length;
            for (int i = 0; i < machines.length; i++) {
                if (machines[i] > sum) {
                    res = Math.max(res, machines[i] - sum);
                }
                res = Math.max(res, Math.abs(pre - i * sum));
                pre += machines[i];
            }
            return res;
        }
        return -1;
    }
}
