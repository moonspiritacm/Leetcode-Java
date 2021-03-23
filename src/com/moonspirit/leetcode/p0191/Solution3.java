package com.moonspirit.leetcode.p0191;

/**
 * 位运算优化。O(k) O(1)
 * 循环次数等于二进制中1的个数。
 */
public class Solution3 {
    public int hammingWeight(int n) {
        int num = 0;
        while (n != 0) {
            n &= (n - 1);
            num++;
        }
        return num;
    }
}
