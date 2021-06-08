package com.moonspirit.leetcode.p0590;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 迭代。O(n) O(n-1)
 */
class SolutionB {
    public List<Integer> postorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Stack<Node> stk = new Stack<>();
        stk.push(root);
        while (!stk.isEmpty()) {
            Node node = stk.pop();
            res.add(node.val);
            for (Node n : node.children) {
                stk.push(n);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
