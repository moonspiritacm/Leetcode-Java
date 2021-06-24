package com.moonspirit.leetcode.p0149;

/**
 * 暴力枚举。O(n^3) O(1)
 * ①外层循环：枚举各条直线（点对），O(n^2);
 * ②内层循环：判断其他各点是否在该直线上，O(n)。
 * ③判断三点共线：任意二点斜率相等，将除法变换为乘法，避免精度、零等问题。
 */
class SolutionB {
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0 || points[0].length != 2) {
            return 0;
        }
        // 剪枝（一），任意2点确定一条直线。
        if (points.length <= 2) {
            return points.length;
        }

        int res = 2;
        for (int i = 0; i < points.length; i++) {
            int[] pi = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int cnt = 2;
                int[] pj = points[j];
                // 剪枝（二）：前面各点与当前点所在直线已经在先前循环中计算了，故只需要枚举后续各点。
                for (int k = j + 1; k < points.length; k++) {
                    int[] pk = points[k];
                    int s1 = (pj[1] - pi[1]) * (pk[0] - pj[0]);
                    int s2 = (pk[1] - pj[1]) * (pj[0] - pi[0]);
                    if (s1 == s2) {
                        cnt++;
                    }
                }
                res = Math.max(res, cnt);
            }
        }
        return res;
    }
}
