package com.moonspirit.leetcode.p0289;

/**
 * 位运算。O(mn) O(1)
 * 本质上还是一种复合状态，由于只有0/1两种形态，使用低位记录旧状态，高位记录新状态。
 */
class Solution2 {
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
                    if (ii >= 0 && ii < m && jj >= 0 && jj < n && (board[ii][jj] & 1) == 1) {
                        num++;
                    }
                }
                if (board[i][j] == 1 && (num == 2 || num == 3)) {
                    board[i][j] |= 1 << 1;
                } else if (board[i][j] == 0 && num == 3) {
                    board[i][j] |= 1 << 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }
}
