package com.moonspirit.leetcode.p0796;

class Solution {
    public boolean validTicTacToe(String[] board) {
        if (board == null || board.length != 3) {
            return false;
        }

        int n1 = 0;
        int n2 = 0;
        boolean flag1 = false;
        boolean flag2 = false;
        for (String str : board) {
            for (char ch : str.toCharArray()) {
                switch (ch) {
                    case 'O':
                        n2++;
                        break;
                    case 'X':
                        n1++;
                        break;
                    case ' ':
                        break;
                    default:
                        return false;
                }
            }
        }
        for (String str : board) {
            if (str.equals("XXX")) {
                flag1 = true;
            }
            if (str.equals("OOO")) {
                flag1 = true;
            }
        }
        for(int i=0;i<3;i++) {
            if(board[0].charAt(i) == board[1].charAt(i) && board[0].charAt(i) == board[2].charAt(i)) {
                if(board[0].charAt(i) == 'X') {
                    flag1 = true;
                } else {
                    flag2 = true;
                }
            }
        }
        if(board[0].charAt(0) == board[1].charAt(1) && board[0].charAt(0) == board[2].charAt(2)) {
            if (board[0].charAt(0) == 'X') {
                flag1 = true;
            } else {
                flag2 = true;
            }
        }
        if(board[0].charAt(2) == board[1].charAt(1) && board[0].charAt(2) == board[2].charAt(0)) {
            if(board[0].charAt(2) == 'X') {
                flag1 = true;
            } else {
                flag2 = true;
            }
        }
        if()
        return false;
    }
}
