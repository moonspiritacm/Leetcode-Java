package com.moonspirit.leetcode.p0104;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求最优解，一般选用广度优先搜索。O(n) O(n)
 * 执行用时：1 ms, 在所有 Java 提交中击败了 17.10% 的用户
 * 内存消耗：38.2 MB, 在所有 Java 提交中击败了 91.49% 的用户
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int num = queue.size();
            while (num-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res++;
        }
        return res;
    }
}
