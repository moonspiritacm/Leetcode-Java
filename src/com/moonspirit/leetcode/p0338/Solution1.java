package com.moonspirit.leetcode.p0338;

/**
 * 动态规划——最高有效位。O(n) O(1)
 * 每逢2的整数次幂向前进位，1的个数整体加一。bits[i] = bits[i - base] + 1，base取2的整数次幂。
 * 快速判断2的整数次幂：x & (x - 1) == 0。
 * <p>
 * 执行用时：2 ms, 在所有 Java 提交中击败了 60.00% 的用户
 * 内存消耗：42.6 MB, 在所有 Java 提交中击败了 61.24% 的用户
 */
class Solution1 {
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        int base = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & (i - 1)) == 0) {
                base = i;
            }
            bits[i] = bits[i - base] + 1;
        }
        return bits;
    }
}
