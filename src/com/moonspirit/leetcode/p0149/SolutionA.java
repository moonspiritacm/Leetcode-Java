package com.moonspirit.leetcode.p0149;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表。O(n^2*logm) O(n)
 * ①内层循环：锚定某点，遍历求解该点与其余点组成直线的斜率，哈希表存储<斜率，点数>对应关系，求得通过该点的所有直线中点数的最大值，O(n)；
 * ②外层循环：遍历各点，求得全局最大值，O(n)。
 * ③计算斜率：通过辗转相除法计算最大公约数，求得最简分子式，O(logm)。
 */
class SolutionA {
    private int ratio(int x, int y) {
        int MOD = 20001;
        if (x == 0) {
            y = 1;
        } else if (y == 0) {
            x = 1;
        } else {
            if (y < 0) {
                x = -x;
                y = -y;
            }
            int k = gcd(Math.abs(x), Math.abs(y));
            x /= k;
            y /= k;
        }
        return x * MOD + y;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0 || points[0].length != 2) {
            return 0;
        }
        // 剪枝（一），任意2点确定一条直线。
        if (points.length <= 2) {
            return points.length;
        }

        int res = 0;
        for (int i = 0; i < points.length; i++) {
            // 剪枝（三）：对于任意点i，至多有n-i个点共线，当res>=n-i时，结束外层循环。
            // 剪枝（四）：如果找到一条直线经过超半数的点，那么该直线即为即为经过最多点的直线。
            if (res >= points.length - i || res > points.length / 2) {
                break;
            }

            int max = 0;
            Map<Integer, Integer> map = new HashMap<>();
            // 剪枝（二）：前面各点与当前点所在直线已经在先前循环中计算了，故只需要枚举后续各点。
            for (int j = i + 1; j < points.length; j++) {
                int key = ratio(points[i][0] - points[j][0], points[i][1] - points[j][1]);
                map.put(key, map.getOrDefault(key, 1) + 1);
                max = Math.max(max, map.get(key));
            }
            res = Math.max(res, max);
        }
        return res;
    }
}
