package com.moonspirit.leetcode.p0105;

class SolutionA {
    private int index = 0;

    private TreeNode dfs(int[] preorder, int[] inorder, int l, int r) {
        if (index == preorder.length || l > r) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[index++]);
        for (int i = l; i <= r; i++) {
            if (inorder[i] == root.val) {
                root.left = dfs(preorder, inorder, l, i - 1);
                root.right = dfs(preorder, inorder, i + 1, r);
                break;
            }
        }
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }

        return dfs(preorder, inorder, 0, inorder.length - 1);
    }
}
