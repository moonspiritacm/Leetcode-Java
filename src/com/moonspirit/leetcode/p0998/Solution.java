package com.moonspirit.leetcode.p0998;

/**
 * 递归。
 */
class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null || val > root.val) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        if (val < root.val) {
            if (root.right != null) {
                root.right = insertIntoMaxTree(root.right, val);
            } else {
                root.right = new TreeNode(val);
            }
        }
        return root;
    }
}
