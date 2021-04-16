package com.moonspirit.leetcode.p0130;

/**
 * 深度优先搜索。O(mn) O(mn)
 */
class SolutionA {
    private void dfs(char[][] board, int[][] dict, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'M';
        for (int k = 0; k < 4; k++) {
            dfs(board, dict, i + dict[k][0], j + dict[k][1]);
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
                dfs(board, dict, 0, j);
            }
            if (board[m - 1][j] == 'O') {
                dfs(board, dict, m - 1, j);
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (board[i][0] == 'O') {
                dfs(board, dict, i, 0);
            }
            if (board[i][n - 1] == 'O') {
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
