package com.moonspirit.leetcode.p1442;

/**
 * 三重循环。O(n^3) O(n)
 */
class SolutionA {
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
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j; k < arr.length; k++) {
                    if (xors[i] == xors[k + 1]) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
