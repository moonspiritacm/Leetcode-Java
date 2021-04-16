package com.moonspirit.leetcode.p0130;

/**
 * 深度优先搜索。O(mn) O(mn)
 */
class SolutionB {
    private void dfs(char[][] board, int[][] dict, int i, int j) {
        for (int k = 0; k < 4; k++) {
            int ii = i + dict[k][0];
            int jj = j + dict[k][1];
            if (ii >= 0 && ii < board.length && jj >= 0 && jj < board[0].length && board[ii][jj] == 'O') {
                board[ii][jj] = 'M';
                dfs(board, dict, ii, jj);
            }
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;
        int[][] dict = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                board[0][j] = 'M';
                dfs(board, dict, 0, j);
            }
            if (board[m - 1][j] == 'O') {
                board[m - 1][j] = 'M';
                dfs(board, dict, m - 1, j);
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = 'M';
                dfs(board, dict, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                board[i][n - 1] = 'M';
                dfs(board, dict, i, n - 1);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'M') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
