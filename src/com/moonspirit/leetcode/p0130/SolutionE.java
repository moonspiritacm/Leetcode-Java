package com.moonspirit.leetcode.p0130;

class UnionFind {
    private int[] pre;
    private int[] rank;

    public UnionFind(int num) {
        pre = new int[num];
        rank = new int[num];
        for (int i = 0; i < num; i++) {
            pre[i] = i;
        }
    }

    public int find(int x) {
        if (pre[x] == x) {
            return x;
        } else {
            return find(pre[x]);
        }
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                pre[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                pre[rootX] = rootY;
            } else {
                pre[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}

class SolutionE {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;
        UnionFind uf = new UnionFind(m * n + 1);
        int[][] dict = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                        uf.union(i * n + j, m * n);
                    } else {
                        for (int k = 0; k < 4; k++) {
                            int ii = i + dict[k][0];
                            int jj = j + dict[k][1];
                            if (ii >= 0 && ii < m && jj >= 0 && jj < n && board[ii][jj] == 'O') {
                                uf.union(i * n + j, ii * n + jj);
                            }
                        }
                    }
                }
            }
        }
        int type = uf.find(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && uf.find(i * n + j) != type) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
