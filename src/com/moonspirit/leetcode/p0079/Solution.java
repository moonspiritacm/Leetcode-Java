package com.moonspirit.leetcode.p0079;

/**
 * 回溯。O(mn3^L) O(mn)
 */
class Solution {
    private boolean dfs(char[][] board, char[] chs, int[][] dict, int i, int j, int n) {
        if (n == chs.length) {
            return true;
        }

        boolean flag = false;
        for (int k = 0; k < 4; k++) {
            int ii = i + dict[k][0];
            int jj = j + dict[k][1];
            if (ii >= 0 && ii < board.length && jj >= 0 && jj < board[0].length && board[ii][jj] == chs[n]) {
                board[ii][jj] = '0';
                if (dfs(board, chs, dict, ii, jj, n + 1)) {
                    return true;
                }
                board[ii][jj] = chs[n];
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return word.length() == 0;
        }

        char[] chs = word.toCharArray();
        int[][] dict = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == chs[0]) {
                    board[i][j] = '0';
                    if (dfs(board, chs, dict, i, j, 1)) {
                        return true;
                    }
                    board[i][j] = chs[0];
                }
            }
        }
        return false;
    }
}
