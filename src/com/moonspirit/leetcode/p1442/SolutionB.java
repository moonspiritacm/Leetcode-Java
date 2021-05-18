package com.moonspirit.leetcode.p1442;

/**
 * 二重循环。O(n^2) O(n)
 */
class SolutionB {
    public int countTriplets(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        int res = 0;
        int[] xors = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            xors[i + 1] = xors[i] ^ arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            for (int k = i + 1; k < arr.length; k++) {
                if (xors[i] == xors[k + 1]) {
                    res += k - i;
                }
            }
        }
        return res;
    }
}
