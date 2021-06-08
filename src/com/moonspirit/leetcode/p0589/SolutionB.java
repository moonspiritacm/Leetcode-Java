package com.moonspirit.leetcode.p0589;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 迭代。O(n) O(n-1)
 */
class SolutionB {
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Stack<Node> stk = new Stack<>();
        stk.push(root);
        while (!stk.isEmpty()) {
            Node node = stk.pop();
            List<Node> children = node.children;
            res.add(node.val);
            for (int i = children.size() - 1; i >= 0; i--) {
                stk.push(children.get(i));
            }
        }
        return res;
    }
}
