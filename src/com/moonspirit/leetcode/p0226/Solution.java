package com.moonspirit.leetcode.p0226;

/**
 * 递归。O(n) O(logn)
 * 如果当前遍历到的节点root的左右子树都已经翻转，那么我们只需要交换两棵子树的位置，即可完成以root为根节点的整棵子树的翻转。
 * <p>
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：35.9 MB, 在所有 Java 提交中击败了 40.81% 的用户
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
