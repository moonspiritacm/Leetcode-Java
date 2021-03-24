package com.moonspirit.leetcode.p0012;

/**
 * 编码表。O(1) O(1)
 */
class Solution1 {
    public String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return "";
        }

        String[] four = new String[]{"", "M", "MM", "MMM"};
        String[] three = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] two = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] one = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return four[num / 1000] + three[num % 1000 / 100] + two[num % 100 / 10] + one[num % 10];
    }
}
