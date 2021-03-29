package com.moonspirit.leetcode.p0199;

import java.util.ArrayList;
import java.util.List;

/**
 * 深度优先搜索。O(n) O(n)
 * 先遍历右子树，在遍历左子树。
 * 对于每层，最右边的结点一定最先被遍历到，将其加入结果列表。
 * 记录树的深度，当本层还没有结点加入列表时（树的深度大于列表规模），将其加入结果列表。
 */
class Solution1 {
    private List<Integer> res = new ArrayList<>();

    private void helper(TreeNode root, int height) {
        if (root == null) {
            return;
        }

        if (res.size() <= height) {
            res.add(root.val);
        }

        helper(root.right, height + 1);
        helper(root.left, height + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return res;
        }

        helper(root, 0);
        return res;
    }
}
