package com.moonspirit.leetcode.p0103;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 对于奇数行，列表每次从头部插入。O(n) O(n)
 * 执行用时：1 ms, 在所有 Java 提交中击败了 98.78% 的用户
 * 内存消耗：38.7 MB, 在所有 Java 提交中击败了 19.64% 的用户
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int num = queue.size();
            List<Integer> ans = new ArrayList<>();
            while (num-- > 0) {
                TreeNode node = queue.poll();
                if (res.size() % 2 == 1) {
                    ans.add(0, node.val);
                } else {
                    ans.add(node.val);
                }
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
