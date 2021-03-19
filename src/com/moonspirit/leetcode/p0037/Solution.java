package com.moonspirit.leetcode.p0037;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private boolean[][] row = new boolean[9][9];
    private boolean[][] col = new boolean[9][9];
    private boolean[][][] block = new boolean[3][3][9];
    private List<int[]> todo = new ArrayList<>();

    private void helper(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= 9 || j >= 9) {
            return;
        }

        int ii = i;
        int jj = j;
        while (true) {
            if (ii + 1 == 9) {
                jj++;
                ii = 0;
            }
            if (board[ii][jj] == 0) {
                break;
            }
            ii++;
        }

        for (int x = 0; x < 9; i++) {
            if (true) {
                board[i][j] = (char) x;
                helper(board, ii, j);
                board[i][j] = 0;
            }
        }
    }

    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return;
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    todo.add(new int[]{i, j});
                } else {
                    int x = board[i][j] - '0';
                    row[i][x] = true;
                    col[j][x] = true;
                    block[i / 3][j / 3][x] = true;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.printf("%d ", row[i][j]);
            }
            System.out.println();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.printf("%d ", col[i][j]);
            }
            System.out.println();
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int x = 0; x < 9; j++) {
                    System.out.printf("%d ", block[i][j][x]);
                }
            }
            System.out.println();
        }


    }
}
