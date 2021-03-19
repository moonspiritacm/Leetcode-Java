package com.moonspirit.leetcode.p0144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 迭代（通用）。O(n) O(n)/O(logn)
 */
class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        while (true) {
            // 入栈，处理左子树
            while (root != null) {
                res.add(root.val);
                stk.push(root);
                root = root.left;
            }
            // 出栈，处理右子树
            if (stk.isEmpty()) {
                break;
            }
            root = stk.pop();
            root = root.right;
        }
        return res;
    }
}
