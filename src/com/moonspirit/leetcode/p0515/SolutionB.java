package com.moonspirit.leetcode.p0515;

import java.util.ArrayList;
import java.util.List;

/**
 * 深度优先搜索。O(n) O(n)
 */
class SolutionB {
    List<Integer> res = new ArrayList<>();

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        while (res.size() - 1 < depth) {
            res.add(Integer.MIN_VALUE);
        }
        if (root.val > res.get(depth)) {
            res.set(depth, root.val);
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        dfs(root, 0);
        return res;
    }
}
