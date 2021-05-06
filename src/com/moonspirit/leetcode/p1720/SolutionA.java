package com.moonspirit.leetcode.p1720;

/**
 * 异或运算。O(n) O(1)
 */
class SolutionA {
    public int[] decode(int[] encoded, int first) {
        if (encoded == null || encoded.length == 0) {
            return new int[]{first};
        }

        int[] res = new int[encoded.length + 1];
        res[0] = first;
        for (int i = 1; i <= encoded.length; i++) {
            res[i] = res[i - 1] ^ encoded[i - 1];
        }
        return res;
    }
}
