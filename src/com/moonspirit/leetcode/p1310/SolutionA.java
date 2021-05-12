package com.moonspirit.leetcode.p1310;

/**
 * 前缀数组。O(m+n) O(1)
 */
class SolutionA {
    public int[] xorQueries(int[] arr, int[][] queries) {
        if (arr == null || arr.length == 0 || queries == null || queries.length == 0) {
            return new int[0];
        }

        int[] res = new int[queries.length];
        for (int i = 1; i < arr.length; i++) {
            arr[i] ^= arr[i - 1];
        }
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] == 0) {
                res[i] = arr[queries[i][1]];
            } else {
                res[i] = arr[queries[i][0] - 1] ^ arr[queries[i][1]];
            }
        }
        return res;
    }
}
