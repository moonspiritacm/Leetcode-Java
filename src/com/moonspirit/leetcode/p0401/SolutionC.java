package com.moonspirit.leetcode.p0401;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯组合。
 */
class SolutionC {
    private void backtrace(int num, int index, int sum, int len, List<String> list) {
        if (num == 0) {
            String res = String.valueOf(sum);
            if (len == 6 && sum < 10) {
                res = "0" + res;
            }
            list.add(res);
            return;
        }

        for (int i = index; i <= len - num; i++) {
            if (len == 6 && (sum + (1 << i) < 60) || len == 4 && (sum + (1 << i) < 12)) {
                sum += 1 << i;
                backtrace(num - 1, i + 1, sum, len, list);
                sum -= 1 << i;
            } else {
                break;
            }
        }
    }

    public List<String> readBinaryWatch(int turnedOn) {
        if (turnedOn < 0 || turnedOn > 10) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i <= turnedOn; i++) {
            List<String> hList = new ArrayList<>();
            List<String> mList = new ArrayList<>();
            backtrace(i, 0, 0, 4, hList);
            backtrace(turnedOn - i, 0, 0, 6, mList);
            for (String s1 : hList) {
                for (String s2 : mList) {
                    res.add(s1 + ":" + s2);
                }
            }
        }
        return res;
    }
}
