package com.moonspirit.leetcode.p0695;

/**
 * 并查集。O(amn) O(mn)
 */
class UnionFind {
    private int max;
    private int[] pre;
    private int[] rank;
    private int[] size;

    public UnionFind(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        pre = new int[m * n];
        rank = new int[m * n];
        size = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    max = 1;
                    pre[i * n + j] = i * n + j;
                    size[i * n + j] = 1;
                }
            }
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
            max = Math.max(max, size[rootX] + size[rootY]);
            if (rank[rootX] > rank[rootY]) {
                pre[rootY] = rootX;
                size[rootX] += size[rootY];
            } else if (rank[rootX] < rank[rootY]) {
                pre[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                pre[rootY] = rootX;
                size[rootX] += size[rootY];
                rank[rootX]++;
            }
        }
    }

    public int getMax() {
        return this.max;
    }
}

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        int[][] dict = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int ii = i + dict[k][0];
                        int jj = j + dict[k][1];
                        if (ii >= 0 && ii < m && jj >= 0 && jj < n && grid[ii][jj] == 1) {
                            uf.union(i * n + j, ii * n + jj);
                        }
                    }
                }
            }
        }
        return uf.getMax();
    }
}
