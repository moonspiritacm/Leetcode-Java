package com.moonspirit.leetcode.p1310;

/**
 * 数组前缀异或。O(m+n) O(1)
 */
class SolutionA {
    public int[] xorQueries(int[] arr, int[][] queries) {
        if (arr == null || arr.length == 0 || queries == null || queries.length == 0) {
            return new int[0];
        }

        int[] xor = new int[arr.length + 1];
        int[] res = new int[queries.length];
        for (int i = 0; i < arr.length; i++) {
            xor[i + 1] = xor[i] ^ arr[i];
        }
        for (int i = 0; i < queries.length; i++) {
            res[i] = xor[queries[i][0]] ^ xor[queries[i][1] + 1];
        }
        return res;
    }
}
