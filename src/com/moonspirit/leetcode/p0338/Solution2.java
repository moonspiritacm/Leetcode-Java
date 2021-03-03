package com.moonspirit.leetcode.p0338;

/**
 * 动态规划——最低有效位。O(n) O(1)
 * 向左移位，末尾由0或1补充，类似裂变的概念。例如，4(100) -> 8(1000)、9(1001)。
 * 对2取整：i>>1；对2取余：i&1。
 * <p>
 * 执行用时：1 ms, 在所有 Java 提交中击败了 99.95% 的用户
 * 内存消耗：42.7 MB, 在所有 Java 提交中击败了 21.15% 的用户
 */
class Solution2 {
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }
}
