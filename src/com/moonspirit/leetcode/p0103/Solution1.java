package com.moonspirit.leetcode.p0103;

import java.util.*;

/**
 * 对于奇数行，加入结果列表之前一次性反转。O(n) O(n)
 * 执行用时：1 ms, 在所有 Java 提交中击败了 98.78% 的用户
 * 内存消耗：38.4 MB, 在所有 Java 提交中击败了 84.75% 的用户
 */
class Solution1 {
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
                ans.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (res.size() % 2 == 1) {
                Collections.reverse(ans);
            }
            res.add(ans);
        }
        return res;
    }
}
