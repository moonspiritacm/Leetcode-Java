package com.moonspirit.leetcode.p0338;

/**
 * 直接计算。O(n*sizeof(k)) O(1)
 * 位运算：对于任意整数x，x &= x - 1 可以将x的二进制表示的最后一个1变成0。
 * <p>
 * 执行用时：2 ms, 在所有 Java 提交中击败了 60.00% 的用户
 * 内存消耗：42.9 MB, 在所有 Java 提交中击败了 5.38% 的用户
 */
class Solution {
    private int helper(int num) {
        int cnt = 0;
        while (num != 0) {
            num &= (num - 1);
            cnt++;
        }
        return cnt;
    }

    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            bits[i] = helper(i);
        }
        return bits;
    }
}
