package com.moonspirit.leetcode.p0104;

/**
 * 深度优先搜索。O(n) O(h)
 * 二叉树的最大深度为 max(l,r) + 1
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：38.5 MB, 在所有 Java 提交中击败了 33.81% 的用户
 */
class Solution1 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int h1 = maxDepth(root.left);
        int h2 = maxDepth(root.right);
        return Math.max(h1, h2) + 1;
    }
}
