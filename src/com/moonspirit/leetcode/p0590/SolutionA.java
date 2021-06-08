package com.moonspirit.leetcode.p0590;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归。O(n) O(n)
 */
class SolutionA {
    private void dfs(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }

        for (Node node : root.children) {
            dfs(node, res);
        }
        res.add(root.val);
    }

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }
}
