package com.moonspirit.leetcode.p0012;

/**
 * 贪心。O(1) O(1)
 */
class Solution {
    public String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return "";
        }

        int[] base = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] dict = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < base.length && num != 0; i++) {
            while (num >= base[i]) {
                sb.append(dict[i]);
                num -= base[i];
            }
        }
        return sb.toString();
    }
}
