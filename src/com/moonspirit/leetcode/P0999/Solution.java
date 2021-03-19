package com.moonspirit.leetcode.P0999;

/**
 * 编程练习。
 */
class Solution {
    public int numRookCaptures(char[][] board) {
        if (board == null || board.length != 8 || board[0].length != 8) {
            return 0;
        }

        int ir = 0;
        int jr = 0;
        int num = 0;
        int[][] dirt = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean flag = true;
        for (int i = 0; i < 8 && flag; i++) {
            for (int j = 0; j < 8 && flag; j++) {
                if (board[i][j] == 'R') {
                    ir = i;
                    jr = j;
                    flag = false;
                }
            }
        }
        for (int x = 0; x < 4; x++) {
            int i = ir + dirt[x][0];
            int j = jr + dirt[x][1];
            while (i >= 0 && j >= 0 && i < 8 && j < 8) {
                if (board[i][j] == 'B') {
                    break;
                }
                if (board[i][j] == 'p') {
                    num++;
                    break;
                }
                i += dirt[x][0];
                j += dirt[x][1];
            }
        }
        return num;
    }
}
