package com.moonspirit.leetcode.p0997;

/**
 * 有向图的入度和出度。O(n) O(n)
 * 出度表示信任他人，入度表示被信任。法官出度0，入度N-1。
 */
class Solution {
    public int findJudge(int N, int[][] trust) {
        if (N < 1 || trust == null) {
            return -1;
        }

        int[] in = new int[N + 1];
        int[] out = new int[N + 1];
        for (int[] t : trust) {
            out[t[0]]++;
            in[t[1]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (out[i] == 0 && in[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }
}
