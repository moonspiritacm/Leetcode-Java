package com.moonspirit.leetcode.p0589;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归。O(N) O(N)
 */
class SolutionA {
    private List<Integer> res;

    private void dfs(Node root) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        for (Node node : root.children) {
            dfs(node);
        }
    }

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        res = new ArrayList<>();
        dfs(root);
        return res;
    }
}
