package com.moonspirit.leetcode.p0012;

/**
 * 编码表。O(1) O(1)
 */
class SolutionA {
    public String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return "";
        }

        String[] thousand = {"", "M", "MM", "MMM"};
        String[] hundred = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] ten = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] one = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return thousand[num / 1000] + hundred[num % 1000 / 100] + ten[num % 100 / 10] + one[num % 10];
    }
}
