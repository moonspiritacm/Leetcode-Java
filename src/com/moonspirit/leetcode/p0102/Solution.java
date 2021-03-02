package com.moonspirit.leetcode.p0102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 广度优先搜索。O(n) O(n)
 * 第i次迭代可以得到二叉树第i层的全部元素：第i次迭代前，队列中的所有元素就是第i层的所有元素，并且按照从左向右的顺序排列。
 * 执行用时：1 ms, 在所有 Java 提交中击败了 94.41% 的用户
 * 内存消耗：38.6 MB, 在所有 Java 提交中击败了 68.32% 的用户
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> ans = new ArrayList<>();
            int num = queue.size();
            while (num-- > 0) {
                TreeNode node = queue.poll();
                ans.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(ans);
        }
        return res;
    }
}
