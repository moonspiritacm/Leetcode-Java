package com.moonspirit.leetcode.p0393;

/**
 * 位运算。O(n) O(1)
 */
class SolutionA {
    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0) {
            return false;
        }

        int cnt = 0;
        int mask1 = 1 << 7;  // 10000000
        int mask2 = 1 << 6;  // 01000000
        for (int i = 0; i < data.length; i++) {
            if (cnt == 0) {
                int mask = 1 << 7;
                while ((data[i] & mask) != 0) {
                    cnt++;
                    mask >>= 1;
                }
                if (cnt == 0) {
                    continue;
                }
                if (cnt > 4 || cnt == 1) {
                    return false;
                }
            } else {
                if ((data[i] & mask1) != 0 && (data[i] & mask2) == 0) {
                    cnt--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
