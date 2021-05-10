package com.moonspirit.leetcode.p0872;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 深度优先搜索（迭代）。O(n) O(n)
 */
class SolutionB {
    private List<Integer> dfs(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            if (root.left == null && root.right == null) {
                res.add(root.val);
            }
            root = root.right;
        }
        return res;
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2 == null;
        }
        if (root2 == null) {
            return root1 == null;
        }

        List<Integer> arr1 = dfs(root1);
        List<Integer> arr2 = dfs(root2);
        return arr1.equals(arr2);
//        if (arr1.size() != arr2.size()) {
//            return false;
//        } else {
//            for (int i = 0; i < arr1.size(); i++) {
//                if (arr1.get(i) != arr2.get(i)) {
//                    return false;
//                }
//            }
//        }
//        return true;
    }
}
