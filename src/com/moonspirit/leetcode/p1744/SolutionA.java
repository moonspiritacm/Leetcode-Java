package com.moonspirit.leetcode.p1744;

/**
 * 数组前缀和。O(n+q) O(n)
 * ①最慢速率，保证前i-1天不能把第j类糖果吃完，即sum[j]>i;
 * ②最快速率，保证前i天不能吃不到第j类糖果，即sum[j-1]<(i+1)*Cap
 */
class SolutionA {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        if (queries == null || queries.length == 0 || queries[0].length != 3) {
            return new boolean[0];
        }

        long[] sum = new long[candiesCount.length];
        sum[0] = candiesCount[0];
        for (int i = 1; i < candiesCount.length; i++) {
            sum[i] = sum[i - 1] + candiesCount[i];
        }

        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long l1 = queries[i][1];
            long l2 = sum[queries[i][0]];
            long r1 = (long)(queries[i][1] + 1) * queries[i][2];
            long r2 = queries[i][0] == 0 ? 0 : sum[queries[i][0] - 1];
            res[i] = l1 < l2 && r2 < r1;
        }
        return res;
    }
}
