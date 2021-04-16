package com.moonspirit.leetcode.p0130;

import java.util.Stack;

/**
 * 深度优先搜索。O(mn) O(mn)
 */
class SolutionC {
    private void bfs(char[][] board, int[][] dict, int i, int j) {
        Stack<Integer> stk = new Stack<>();
        stk.push(i * board[0].length + j);
        board[i][j] = 'M';
        while (!stk.isEmpty()) {
            int pos = stk.pop();
            for (int k = 0; k < 4; k++) {
                int ii = pos / board[0].length + dict[k][0];
                int jj = pos % board[0].length + dict[k][1];
                if (ii >= 0 && ii < board.length && jj >= 0 && jj < board[0].length && board[ii][jj] == 'O') {
                    board[ii][jj] = 'M';
                    stk.push(ii * board[0].length + jj);
                }
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
                bfs(board, dict, 0, j);
            }
            if (board[m - 1][j] == 'O') {
                bfs(board, dict, m - 1, j);
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (board[i][0] == 'O') {
                bfs(board, dict, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                bfs(board, dict, i, n - 1);
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
