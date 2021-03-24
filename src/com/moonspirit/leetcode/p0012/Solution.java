package com.moonspirit.leetcode.p0012;

/**
 * 贪心。O(1) O(1)
 */
class Solution {
    public String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return "";
        }

        int[] board = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] roman = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        StringBuilder sb = new StringBuilder();
        for (int i = 12; i >= 0 && num > 0; i--) {
            while (num >= board[i]) {
                sb.append(roman[i]);
                num -= board[i];
            }
        }
        return sb.toString();
    }
}
