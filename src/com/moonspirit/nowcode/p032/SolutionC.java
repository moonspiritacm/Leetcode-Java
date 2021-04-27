package com.moonspirit.nowcode.p032;

import java.util.ArrayList;
import java.util.List;

/**
 * 深度优先搜索。O(n) O(n)
 */
class SolutionC {
    private void dfs(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) {
            return;
        }

        if (level == res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        dfs(root.left, res, level + 1);
        dfs(root.right, res, level + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }
}
