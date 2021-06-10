package com.moonspirit.leetcode.p0513;

/**
 * 深度优先搜索。O(n) O(n)
 */
class SolutionB {
    private int res;
    private int max;

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (depth > max) {
            max = depth;
            res = root.val;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }

        res = -1;
        max = -1;
        dfs(root, 0);
        return res;
    }
}
