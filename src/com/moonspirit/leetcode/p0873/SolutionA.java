package com.moonspirit.leetcode.p0873;

import java.util.HashMap;
import java.util.Map;

/**
 * 动态规划。O(n^2) O(n^2)
 */
class SolutionA {
    public int lenLongestFibSubseq(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }

        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }

        int res = 0;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int num = arr[j] - arr[i];
                if (num >= arr[i]) {
                    continue;
                }
                if (map.containsKey(num)) {
                    int p = map.get(num);
                    dp[i][j] = dp[p][i] == 0 ? 3 : dp[p][i] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
