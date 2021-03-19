package com.moonspirit.leetcode.p0998;

/**
 * 递归。
 * 新值大于树根，新值变成跟，根称为左孩子；
 * 新值小于树根，新值插入右子树，右子树为空则直接插入，不为空则递归。
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
