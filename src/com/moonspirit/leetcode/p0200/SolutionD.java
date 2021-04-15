package com.moonspirit.leetcode.p0200;

/**
 * 并查集。O(amn) O(mn)
 */
class UnionFind {
    private int count;
    private int[] pre;
    private int[] rank;

    public UnionFind(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        pre = new int[m * n];
        rank = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    pre[i * n + j] = i * n + j;
                    count++;
                }
            }
        }
    }

    public int find(int x) {
        if (pre[x] != x) {
            return find(pre[x]);
        } else {
            return x;
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
            count--;
        }
    }

    public int getCount() {
        return this.count;
    }
}

class SolutionD {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        UnionFind uf = new UnionFind(grid);
        int m = grid.length;
        int n = grid[0].length;
        int[][] dict = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    for (int k = 0; k < 4; k++) {
                        int ii = i + dict[k][0];
                        int jj = j + dict[k][1];
                        if (ii >= 0 && ii < m && jj >= 0 && jj < n && grid[ii][jj] == '1') {
                            uf.union(i * n + j, ii * n + jj);
                        }
                    }
                }
            }
        }
        return uf.getCount();
    }
}
