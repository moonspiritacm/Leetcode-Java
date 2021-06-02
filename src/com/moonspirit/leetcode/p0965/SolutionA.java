package com.moonspirit.leetcode.p0965;

class SolutionA {
    public boolean isUnivalTree(TreeNode root) {
        return root == null ||
                (root.left == null || (root.val == root.left.val && isUnivalTree(root.left))) &&
                        (root.right == null || (root.val == root.right.val && isUnivalTree(root.right)));
    }
}
