package com.moonspirit.leetcode.p0200;

/**
 * 并查集。O(mn*α(mn)) O(mn)
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

    private int find(int x) {
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
            count--;
        }
    }

    public int getCount() {
        return count;
    }
}

class Solution2 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        int[][] dirt = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '2';
                    for (int k = 0; k < 4; k++) {
                        int ix = i + dirt[k][0];
                        int jx = j + dirt[k][1];
                        if (ix >= 0 && ix < m && jx >= 0 && jx < n && grid[ix][jx] == '1') {
                            uf.union(i * n + j, ix * n + jx);
                        }
                    }
                }
            }
        }
        return uf.getCount();
    }
}
