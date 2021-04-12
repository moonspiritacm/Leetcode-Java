package com.moonspirit.leetcode.p0617;

import java.util.LinkedList;
import java.util.Queue;

class Solution1 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }

        TreeNode merged = new TreeNode(t1.val + t2.val);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue.offer(merged);
        queue1.offer(t1);
        queue2.offer(t2);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1.left != null || node2.left != null) {
                if (node1.left != null && node2.left != null) {
                    TreeNode left = new TreeNode(node1.left.val + node2.left.val);
                    node.left = left;
                    queue.offer(left);
                    queue1.offer(node1.left);
                    queue2.offer(node2.left);
                } else if (node1.left != null) {
                    node.left = node1.left;
                } else if (node2.left != null) {
                    node.left = node2.left;
                }
            }
            if (node1.right != null || node2.right != null) {
                if (node1.right != null && node2.right != null) {
                    TreeNode right = new TreeNode(node1.right.val + node2.right.val);
                    node.right = right;
                    queue.offer(right);
                    queue1.offer(node1.right);
                    queue2.offer(node2.right);
                } else if (node1.right != null) {
                    node.right = node1.right;
                } else {
                    node.right = node2.right;
                }
            }
        }
        return merged;
    }
}

