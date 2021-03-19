package com.moonspirit.leetcode.p0144;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归。O(n) O(n)/O(logn)
 */
class Solution {
    private List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }

        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return res;
    }
}
