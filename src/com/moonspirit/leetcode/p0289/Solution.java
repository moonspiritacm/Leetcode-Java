package com.moonspirit.leetcode.p0289;

/**
 * 复制数组。O(mn) O(mn)
 */
class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        int[][] old = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                old[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = 0;
                for (int k = 0; k < 8; k++) {
                    int ii = i + dir[k][0];
                    int jj = j + dir[k][1];
                    if (ii >= 0 && ii < m && jj >= 0 && jj < n && old[ii][jj] == 1) {
                        num++;
                    }
                }
                if (old[i][j] == 1 && (num < 2 || num > 3)) {
                    board[i][j] = 0;
                } else if (old[i][j] == 0 && num == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
}
