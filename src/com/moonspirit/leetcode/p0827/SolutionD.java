package com.moonspirit.leetcode.p0827;

import java.util.HashSet;
import java.util.Set;

/**
 * 并查集。O(amn) O(mn)
 */
class UnionFind {
    private int max;
    private int count;
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
                    count++;
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
            count--;
        }
    }

    public int getSize(int x) {
        return this.size[x];
    }

    public int getMax() {
        return this.max;
    }

    public int getCount() {
        return this.count;
    }
}

class SolutionD {
    public int largestIsland(int[][] grid) {
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

        int res = uf.getMax();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int area = 1;
                    Set<Integer> board = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int ii = i + dict[k][0];
                        int jj = j + dict[k][1];
                        if (ii >= 0 && ii < m && jj >= 0 && jj < n && grid[ii][jj] == 1) {
                            board.add(uf.find(ii * n + jj));
                        }
                    }
                    for (int pos : board) {
                        area += uf.getSize(pos);
                    }
                    res = Math.max(res, area);
                }
            }
        }
        return res;
    }
}
