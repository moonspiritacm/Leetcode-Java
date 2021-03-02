package com.moonspirit.leetcode.p0103;

import java.util.*;

/**
 * 两端队列实现首尾插入。O(n) O(n)
 * 执行用时：2 ms, 在所有 Java 提交中击败了 17.41% 的用户
 * 内存消耗：38.6 MB, 在所有 Java 提交中击败了 54.62% 的用户
 */
class Solution2 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int num = queue.size();
            Deque<Integer> ans = new LinkedList<>();
            while (num-- > 0) {
                TreeNode node = queue.poll();
                if (res.size() % 2 == 1) {
                    ans.offerFirst(node.val);
                } else {
                    ans.offerLast(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(new ArrayList<>(ans));
        }
        return res;
    }
}
