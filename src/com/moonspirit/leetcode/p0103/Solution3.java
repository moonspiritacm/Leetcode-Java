package com.moonspirit.leetcode.p0103;

import java.util.ArrayList;
import java.util.List;

/**
 * 深度优先搜索。O(n) O(n)
 * 执行用时：1 ms, 在所有 Java 提交中击败了 98.78% 的用户
 * 内存消耗：38.5 MB, 在所有 Java 提交中击败了 77.35% 的用户
 */
class Solution3 {
    private List<List<Integer>> res = new ArrayList<>();

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (res.size() <= level) {
            res.add(new ArrayList<>());
        }
        if (level % 2 == 0) {
            res.get(level).add(root.val);
        } else {
            res.get(level).add(0, root.val);
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        dfs(root, 0);
        return res;
    }
}
