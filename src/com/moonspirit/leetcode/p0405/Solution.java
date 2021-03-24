package com.moonspirit.leetcode.p0405;

/**
 * 位运算。O(n) O(1)
 * 负数本身就是以二进制补码的形式存储，直接位运算即可。
 */
class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        char[] dict = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        while (num != 0) {
            sb.append(dict[num & 0xf]);
            num >>>= 4;
        }
        return sb.reverse().toString();
    }
}
