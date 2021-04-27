package com.moonspirit.nowcode.p032;

import java.util.*;

/**
 * 层序遍历。O(n) O(n)
 */
class SolutionD {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            List<Integer> ans = new ArrayList<>();
            while (cnt-- > 0) {
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
