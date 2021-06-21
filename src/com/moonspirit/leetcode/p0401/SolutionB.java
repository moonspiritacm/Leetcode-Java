package com.moonspirit.leetcode.p0401;

import java.util.ArrayList;
import java.util.List;

/**
 * 二进制枚举。O(1) O(1)
 */
class SolutionB {
    private int bitCount(int num) {
        int cnt = 0;
        while (num != 0) {
            num &= num - 1;
            cnt++;
        }
        return cnt;
    }

    public List<String> readBinaryWatch(int turnedOn) {
        if (turnedOn < 0 || turnedOn > 10) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < 1024; i++) {
            int h = i >> 6;
            int m = i & 63;
            if (h < 12 && m < 60 && bitCount(i) == turnedOn) {
                res.add(h + ":" + (m < 10 ? "0" + m : m));
            }
        }
        return res;
    }
}
