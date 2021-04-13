package com.moonspirit.leetcode.p0289;

/**
 * 复合状态。O(mn) O(1)
 * 定义状态2为活细胞死掉，状态3为死细胞复活，实现状态同步更新。
 */
class Solution1 {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = 0;
                for (int k = 0; k < 8; k++) {
                    int ii = i + dir[k][0];
                    int jj = j + dir[k][1];
                    if (ii >= 0 && ii < m && jj >= 0 && jj < n && (board[ii][jj] == 1 || board[ii][jj] == 2)) {
                        num++;
                    }
                }
                if (board[i][j] == 1 && (num < 2 || num > 3)) {
                    board[i][j] = 2;
                } else if (board[i][j] == 0 && num == 3) {
                    board[i][j] = 3;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
}
