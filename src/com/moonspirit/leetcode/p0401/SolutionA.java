package com.moonspirit.leetcode.p0401;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间枚举。O(1) O(1)
 */
class SolutionA {
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
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (bitCount(h) + bitCount(m) == turnedOn) {
                    res.add(h + ":" + (m < 10 ? "0" + m : m));
                }
            }
        }
        return res;
    }
}
