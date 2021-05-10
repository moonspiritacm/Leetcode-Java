package com.moonspirit.leetcode.p0872;

import java.util.ArrayList;
import java.util.List;

/**
 * 深度优先搜索（递归）。O(n) O(n)
 */
class SolutionA {
    private void dfs(TreeNode root, List<Integer> arr) {
        if (root.left == null && root.right == null) {
            arr.add(root.val);
        } else {
            if (root.left != null) {
                dfs(root.left, arr);
            }
            if (root.right != null) {
                dfs(root.right, arr);
            }
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2 == null;
        }
        if (root2 == null) {
            return root1 == null;
        }

        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        dfs(root1, arr1);
        dfs(root2, arr2);
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
