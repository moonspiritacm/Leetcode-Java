package com.moonspirit.leetcode.p0102;

import java.util.ArrayList;
import java.util.List;

/**
 * 深度优先搜索。O(n) O(n)
 * 递归状态变量：root - 当前节点，level - 当前深度。
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：38.7 MB, 在所有 Java 提交中击败了 59.58% 的用户
 */
class Solution1 {
    private List<List<Integer>> res = new ArrayList<>();

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (res.size() <= level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        dfs(root, 0);
        return res;
    }
}
