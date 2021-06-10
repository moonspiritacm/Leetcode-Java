package com.moonspirit.leetcode.p0513;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先搜索。O(n) O(n-1)
 */
class SolutionA {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            res = queue.peek().val;
            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }
}
