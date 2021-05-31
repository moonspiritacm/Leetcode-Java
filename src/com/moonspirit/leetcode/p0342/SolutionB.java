package com.moonspirit.leetcode.p0342;

/**
 * 取模。O(1) O(1)
 * 4^x = (3+1)^x = 1(mod 3)
 * 4^x-1 = (2^x)^2-1 = (2^x+1)(2^x-1)
 * 任何连续的n个自然数的乘积一定能被n整除，4的整数次幂减一一定能被3整除。
 */
public class SolutionB {
    public boolean isPowerOfFour(int n) {
        //return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
        return n > 0 && (n & (n - 1)) == 0 && (n - 1) % 3 == 0;
    }
}
