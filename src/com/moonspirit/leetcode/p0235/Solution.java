package com.moonspirit.leetcode.p0235;

/**
 * 一趟遍历，找到分岔点。O(n) O(1)
 * 利用二叉搜索树顺序特征，判断节点搜索路径。
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        if (q.val < p.val) {
            TreeNode t = q;
            q = p;
            p = t;
        }

        while (root != null) {
            if (p.val <= root.val && q.val >= root.val) {
                return root;
            } else if (q.val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }
}
