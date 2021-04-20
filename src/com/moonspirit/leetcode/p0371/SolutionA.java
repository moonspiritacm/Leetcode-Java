package com.moonspirit.leetcode.p0371;

/**
 * 位运算。O(1) O(1)
 */
class SolutionA {
    public int getSum(int a, int b) {
        int res = a ^ b;  //无进位加法
        int carry = (a & b) << 1;  //处理进位
        while (carry != 0) {
            int tmp = (carry & res) << 1;
            res = res ^ carry;
            carry = tmp;
        }
        return res;
    }
}
