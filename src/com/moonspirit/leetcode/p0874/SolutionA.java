package com.moonspirit.leetcode.p0874;

import java.util.HashSet;
import java.util.Set;

/**
 * 模拟。O(m+n) O(n)
 */
class SolutionA {
    public int robotSim(int[] commands, int[][] obstacles) {
        if (commands == null || commands.length == 0) {
            return 0;
        }

        long LENGTH = 100001;
        Set<Long> set = new HashSet<>();
        if (obstacles != null) {
            for (int i = 0; i < obstacles.length; i++) {
                set.add(obstacles[i][0] * LENGTH + obstacles[i][1]);
            }
        }

        int res = 0;
        int di = 0;
        int x = 0;
        int y = 0;
        int[][] dict = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -2) {
                di = (di + 3) % 4;
            } else if (commands[i] == -1) {
                di = (di + 1) % 4;
            } else {
                while (commands[i]-- > 0 && !set.contains((x + dict[di][0]) * LENGTH + y + dict[di][1])) {
                    x += dict[di][0];
                    y += dict[di][1];
                }
            }
            res = Math.max(res, x * x + y * y);
        }
        return res;
    }
}
